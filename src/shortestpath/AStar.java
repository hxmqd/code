package shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*

    最短路径A*算法
 */
public class AStar {

    // 上下左右
    public final static int[] dx = {0, -1, 0, 1};
    public final static int[] dy = {-1, 0, 1, 0};

    // 最外圈都是1表示不可通过
    final static public int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    public static void main(String[] args) {

        Point start = new Point(1, 1);
        Point end = new Point(4, 12);

        Stack<Point> stack = path(start, end);
        if (stack == null) {
            System.out.println("不可达");

        } else {
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }


    }

    public static Stack<Point> path(Point start, Point end) {

        //openTab表示可以移动到的格子集合，closeTab表示已经移动过的格子集合。
        ArrayList<Point> openTab = new ArrayList<>();
        ArrayList<Point> closeTab = new ArrayList();
        Stack<Point> pathStack = new Stack<>();
        start.parent = null;
        //当前拓展点
        Point currentPoint = new Point(start.x, start.y);
        boolean flag = true;

        while (flag) {
            for (int i = 0; i < 4; i++) {
                int fx = currentPoint.x + dx[i];
                int fy = currentPoint.y + dy[i];
                Point tempPoint = new Point(fx, fy);
                // 由于边界都是1中间障碍物也是1，，这样不必考虑越界和障碍点扩展问题
                //如果不设置边界那么fx >=map.length &&fy>=map[0].length判断越界问题
                if (map[fx][fy] == 1) {
                    continue;
                } else {
                    if (end.equals(tempPoint)) {
                        flag = false;
                        end.parent = currentPoint;
                        break;
                    }

                    tempPoint.G = currentPoint.G + 10;

                    tempPoint.H = Point.getDis(tempPoint, end);
                    tempPoint.F = tempPoint.G + tempPoint.H;
                    if (openTab.contains(tempPoint)) {
                        int pos = openTab.indexOf(tempPoint);
                        Point temp = openTab.get(pos);
                        if (temp.F > tempPoint.F) {
                            openTab.remove(pos);
                            openTab.add(tempPoint);
                            tempPoint.parent = currentPoint;
                        }
                    } else if (closeTab.contains(tempPoint)) {
                        int pos = closeTab.indexOf(tempPoint);
                        Point temp = closeTab.get(pos);
                        if (temp.F > tempPoint.F) {
                            closeTab.remove(pos);
                            openTab.add(tempPoint);
                            tempPoint.parent = currentPoint;
                        }

                    } else {
                        openTab.add(tempPoint);
                        tempPoint.parent = currentPoint;
                    }
                }

            }

            if (openTab.isEmpty()) {
                return null;
            }
            if (!flag) {
                break;
            }
            openTab.remove(currentPoint);
            closeTab.add(currentPoint);
            Collections.sort(openTab);
            currentPoint = openTab.get(0);
        }

        Point node = end;
        while (node.parent != null) {
            pathStack.push(node);
            node = node.parent;
        }
        return pathStack;

    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    Point parent;
    //F 从初始点经节点n到目标点的估价函数
    //G 在状态空间中，从初始节点到n节点的实际代价
    //H 从n节点到目标节点最佳路径的估计代价
    int F, G, H;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.F = 0;
        this.G = 0;
        this.H = 0;
    }

    @Override
    public int compareTo(Point o) {
        return this.F - o.F;
    }

    public boolean equals(Object obj) {
        Point point = (Point) obj;
        if (point.x == this.x && point.y == this.y)
            return true;
        return false;
    }

    //点之间步数
    public static int getDis(Point p1, Point p2) {
        int dis = Math.abs(p1.x - p2.x) * 10 + Math.abs(p1.y - p2.y) * 10;
        return dis;
    }

    public String toString() {
        return "[" + this.x + "," + this.y + "]";
    }
}

