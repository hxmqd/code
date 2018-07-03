//package shortestpath;
//
//import java.util.ArrayList;
//import java.util.Stack;
//
//public class AStar {
//
//    // 前四个是上下左右，后四个是斜角
//    public final static int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};
//
//    public final static int[] dy = {-1, 0, 1, 0, 1, -1, -1, 1};
//
//    // 最外圈都是1表示不可通过
//    final static public int[][] map = {
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
//
//    public static void main(String[] args) {
//
//        Point start = new Point(1,1);
//        Point end = new Point(10, 13);
//
//
//
//    }
//
//    public static Stack<Point> path(Point start, Point end){
//
//        ArrayList<Point> openTab = new ArrayList<>();
//        ArrayList<Point> closeTab = new ArrayList();
//        Stack<Point> pathStack = new Stack<>();
//        start.parent = null;
//        //当前拓展点
//        Point currentPoint = new Point(start.x, start.y);
//
//    }
//}
//
//class Point implements Comparable<Point> {
//    int x;
//    int y;
//    Point parent;
//    int F, G, H;
//
//    public Point(int x, int y) {
//        super();
//        this.x = x;
//        this.y = y;
//        this.F = 0;
//        this.G = 0;
//        this.H = 0;
//    }
//
//    @Override
//    public int compareTo(Point o) {
//        return this.F - o.F;
//    }
//
//    public boolean equals(Object obj) {
//        Point point = (Point) obj;
//        if (point.x == this.x && point.y == this.y)
//            return true;
//        return false;
//    }
//
//    //点之间步数
//    public static int getDis(Point p1, Point p2) {
//        int dis = Math.abs(p1.x - p2.x) * 10 + Math.abs(p1.y - p2.y) * 10;
//        return dis;
//    }
//}
