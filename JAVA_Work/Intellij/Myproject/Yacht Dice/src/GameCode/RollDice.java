package GameCode;

import java.util.Arrays;
import java.util.Scanner;

public class RollDice {
    int[] dice = new int[5];
    int[] diceKeep = new int[5];
    int keep = 0;
    int cycle = 1;

    public void rollDice(RollDice a, Scanner sc) {
        a.keep=0;
        a.cycle = 1;
        a.roll();
        a.choice(sc);
        a.roll();
        a.choice(sc);
        a.roll();
        System.arraycopy(a.dice, a.keep, a.diceKeep, 0, 5-a.keep);
        a.sortDice(a.diceKeep);
    }

    private void roll() {
        Arrays.fill(dice, 0);
        for (int i = 0; i < 5-keep; i++) {
            dice[i] = (int) (Math.random() * 6 + 1);
        }
        sortDice(dice);
        System.out.println(cycle + "번째 굴림");
        cycle++;
    }

    private void choice(Scanner sc) {
        System.out.println("저장된 주사위 값= " + Arrays.toString(diceKeep));
        System.out.println("굴려진 주사위 값= " + Arrays.toString(dice));
        System.out.println("※굴려진 주사위 값을 저장하려면 원하는 숫자를 입력하세요.");
        System.out.println("※저장된 주사위 값을 제거하려면 원하는 숫자를 음수로 입력하세요.");
        System.out.println("※0을 입력하면 다음 주사위 굴림으로 넘어갑니다.");
        String input = sc.nextLine();

        if(!input.replaceAll( "[0-9]", "").isEmpty()){
            System.out.println("숫자만 입력 해 주세요");
            choice(sc);
            return;
        }



        int value = Integer.parseInt(input);
        //입력받음
        if (value > 0) {
            keepDice(value);
            sortDice(dice);
            sortDice(diceKeep);
            choice(sc);
            return;
        } else if (value < 0) {
            removeDice(value);
            sortDice(dice);
            sortDice(diceKeep);
            choice(sc);
            return;
        } else return;

    }

    private void keepDice(int value) {
        for (int i = 0; i < 5; i++) {
            if (value == dice[i]) {
                diceKeep[0] = value;
                dice[i] = 0;
                keep++;
                break;
            }
        }
    }

    private void removeDice(int value) {
        for (int i = 0; i < 5; i++) {
            if ((-1) * value == diceKeep[i]) {
                dice[0] = (-1)*value;
                diceKeep[i] = 0;
                keep--;
                break;
            }
        }
    }

    private void sortDice(int[] dice) {
        int count = 1;
        int temp;

        while (count != 0) {
            count = 0;
            for (int i = 0; i < 4; i++) {
                if (dice[i] > dice[i + 1]) {
                    temp = dice[i];
                    dice[i] = dice[i + 1];
                    dice[i + 1] = temp;
                    count++;
                }
            }
        }
    }
}

//주사위를 3번 굴린다.
//첫번째는 주사위를 5개 굴린다.
//두번째는 첫 번째 결과에서 원하는 주사위는 킵하고 나머지를 굴린다.
//세번째도 두번째랑 마찬가지
