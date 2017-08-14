package algorithm_toolbox.week4;

import java.io.*;
import java.util.*;


public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    public static class Pair {
        Point point1 = null;
        Point point2 = null;
        double distance = 0.0;

        public Pair() {
        }

        Pair(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
            calcDistance();
        }

        void calcDistance() {
            this.distance = distance(point1, point2);
        }

        void update(Point point1, Point point2, double distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }
    }

    static double distance(Point point1, Point point2) {
        double xdist = point2.x - point1.x;
        double ydist = point2.y - point1.y;
        return Math.hypot(xdist, ydist);
    }


    private static void sortByX(List<? extends Point> points) {
        points.sort((Comparator<Point>) (point1, point2) -> {
            if (point1.x < point2.x) {
                return -1;
            }
            if (point1.x > point2.x) {
                return 1;
            }
            return 0;
        });
    }

    private static void sortByY(List<? extends Point> points) {
        points.sort((Comparator<Point>) (point1, point2) -> {
            if (point1.y < point2.y)
                return -1;
            if (point1.y > point2.y)
                return 1;
            return 0;
        });
    }

    private static Pair bruteForce() {
        return bruteForce();
    }

    private static Pair bruteForce(List<? extends Point> points) {
        int numPoints = points.size();
        if (numPoints < 2)
            return null;
        Pair pair = new Pair(points.get(0), points.get(1));
        if (numPoints > 2) {
            for (int i = 0; i < numPoints - 1; i++) {
                Point point1 = points.get(i);
                for (int j = i + 1; j < numPoints; j++) {
                    Point point2 = points.get(j);
                    double distance = distance(point1, point2);
                    if (distance < pair.distance)
                        pair.update(point1, point2, distance);
                }
            }
        }
        return pair;
    }

    private static Pair divideAndConquer(List<? extends Point> points) {
        List<Point> pointsSortedByX = new ArrayList<Point>(points);
        sortByX(pointsSortedByX);
        List<Point> pointsSortedByY = new ArrayList<Point>(points);
        sortByY(pointsSortedByY);
        return divideAndConquer(pointsSortedByX, pointsSortedByY);
    }

    private static Pair divideAndConquer(List<? extends Point> pointsSortedByX, List<? extends Point> pointsSortedByY) {
        int numPoints = pointsSortedByX.size();
        if (numPoints <= 3)
            return bruteForce(pointsSortedByX);

        int dividingIndex = numPoints >>> 1;
        List<? extends Point> leftOfCenter = pointsSortedByX.subList(0, dividingIndex);
        List<? extends Point> rightOfCenter = pointsSortedByX.subList(dividingIndex, numPoints);

        List<Point> tempList = new ArrayList<Point>(leftOfCenter);
        sortByY(tempList);
        Pair closestPair = divideAndConquer(leftOfCenter, tempList);

        tempList.clear();
        tempList.addAll(rightOfCenter);
        sortByY(tempList);
        Pair closestPairRight = divideAndConquer(rightOfCenter, tempList);

        if (closestPairRight.distance < closestPair.distance)
            closestPair = closestPairRight;

        tempList.clear();
        double shortestDistance = closestPair.distance;
        double centerX = rightOfCenter.get(0).x;
        for (Point point : pointsSortedByY)
            if (Math.abs(centerX - point.x) < shortestDistance)
                tempList.add(point);

        for (int i = 0; i < tempList.size() - 1; i++) {
            Point point1 = tempList.get(i);
            for (int j = i + 1; j < tempList.size(); j++) {
                Point point2 = tempList.get(j);
                if ((point2.y - point1.y) >= shortestDistance)
                    break;
                double distance = distance(point1, point2);
                if (distance < closestPair.distance) {
                    closestPair.update(point1, point2, distance);
                    shortestDistance = distance;
                }
            }
        }
        return closestPair;
    }

    private static BufferedReader reader;
    private static StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        List<Point> points = new ArrayList<Point>();
        for (int j = 0; j < n; j++) {
            points.add(new Point(x[j], y[j]));
        }

        Pair dqClosestPair = divideAndConquer(points);
        System.out.println(dqClosestPair.distance);

    }


    private static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }
}