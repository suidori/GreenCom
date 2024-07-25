package GameCode;

public class Check {



    public static boolean checkBy(int[][] chessPiece, int[][] color, int turnColor) {
        int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (color[i][j] == turnColor) {
                    switch (chessPiece[i][j]) {
                        case 1:
                            int pdy = (turnColor == 1) ? 1 : -1;
                            if (j + 1 <= 7 && chessPiece[i + pdy][j + 1] == 6 && color[i + pdy][j + 1] != turnColor) {
                                return true;
                            }
                            if (j - 1 >= 0 && chessPiece[i + pdy][j - 1] == 6 && color[i + pdy][j - 1] != turnColor) {
                                return true;
                            }
                            break;
                        case 2:
                            for (int k = 0; k < 4; k++) {
                                if (checkStraight(i, j, turnColor, dy[k], dx[k], chessPiece, color)) {
                                    return true;
                                }
                            }
                            break;
                        case 3:
                            for (int k = 0; k < 3; k++) {
                                if (i + dy[k] + dy[k + 4] >= 0 && i + dy[k] + dy[k + 4] <= 7
                                        && j + dx[k] + dx[k + 4] >= 0 && j + dx[k] + dx[k + 4] <= 7) {

                                    if (color[i + dy[k] + dy[k + 4]][j + dx[k] + dx[k + 4]] != turnColor
                                            && chessPiece[i + dy[k] + dy[k + 4]][j + dx[k] + dx[k + 4]] == 6) {
                                        return true;
                                    }
                                }
                                if (i + dy[k] + dy[k + 5] >= 0 && i + dy[k] + dy[k + 5] <= 7
                                        && j + dx[k] + dx[k + 5] >= 0 && j + dx[k] + dx[k + 5] <= 7) {
                                    if (color[i + dy[k] + dy[k + 5]][j + dx[k] + dx[k + 5]] != turnColor
                                            && chessPiece[i + dy[k] + dy[k + 5]][j + dx[k] + dx[k + 5]] == 6) {
                                        return true;
                                    }
                                }
                            }
                            if (i - 1 >= 0 && i + 1 <= 7 && j - 2 >= 0) {
                                if (color[i - 1][j - 2] != turnColor
                                        && chessPiece[i - 1][j - 2] == 6) {
                                    return true;
                                }
                                if (color[i + 1][j - 2] != turnColor
                                        && chessPiece[i - 1][j - 2] == 6) {
                                    return true;
                                }
                            }
                            break;
                        case 4:
                            for (int k = 4; k < 8; k++) {
                                if (checkStraight(i, j, turnColor, dy[k], dx[k], chessPiece, color)) {
                                    return true;
                                }
                            }
                            break;
                        case 5:
                            for (int k = 0; k < 8; k++) {
                                if (checkStraight(i, j, turnColor, dy[k], dx[k], chessPiece, color)) {
                                    return true;
                                }
                            }
                            break;
                        case 6:
                            for (int k = 0; k < 8; k++) {
                                if (i + dy[k] >= 0 && i + dy[k] <= 7 && j + dx[k] >= 0 && j + dx[k] <= 7) {
                                    if (color[i + dy[k]][j + dx[k]] != turnColor
                                            && chessPiece[i + dy[k]][j + dx[k]] == 6) {
                                        return true;
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkStraight(int y, int x, int turnColor, int dy, int dx, int[][] chessPiece, int[][] color) {
        if (y + dy < 0 || y + dy > 7 || x + dx < 0 || x + dx > 7) {
            return false;
        }
        if (chessPiece[y + dy][x + dx] == 0) {
            return checkStraight(y + dy, x + dx, turnColor, dy, dx, chessPiece, color);
        } else return chessPiece[y + dy][x + dx] == 6 && color[y + dy][x + dx] != turnColor;

    }
}
