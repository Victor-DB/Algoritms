package algorithms.treugolnik_maxima;

import java.util.Random;

/** С детства Максим был неплохим музыкантом и мастером на все руки. Недавно он самостоятельно
 *  сделал несложный перкуссионный музыкальный инструмент - треугольник. Ему нужно узнать
 *  какова частота звука, издаваемого его музыкальным инструментом.
 *
 *  У Максима есть профессиональный тюнер, с помощью которого можно проигрывать
 *  ноту с заданной частотой. Максим действует следующим образом, он включает на тюнере ноты
 *  с разными частотами и для каждой ноты на слух определяет ближе или дальше она к издаваемому
 *  трегольником звуку, чем предыдущая нота. Поскольку слух у Максима абсолютный, он определяет
 *  это всегда абсолютно верно.
 *
 *  Вам Максим показал запись, в которой приведена последовательность частот, выставляемых им на
 *  тюнере, и про каждую ноту, начиная со второй, записано - ближе или дальше она к звуку
 *  треугольника, чем предыдущая нота. Заранее известно, что частота звучания треугольника
 *  Максима составляет не менее 30 герц и не более 4000 герц.
 *
 *  Требуется написать программу, которая определяет в каком интервале может находиться частота
 *  звучания треугольника.
 *  */
public class Main {

    public static int createRandomValue(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static String getInterval() {
        int frecuency = createRandomValue(30, 4000);

        int i = 1;
        int diff = 0;
        int leftDiff = 4000;
        int leftMinDiff = 4000;
        int leftBorder = 0;
        int rightDiff = 4000;
        int rightMinDiff = 4000;
        int rightBorder = 0;

        while (i < 1000) {
            int iter = createRandomValue(30, 4000);

            if (iter < frecuency) {
                if (i == 1) { diff = frecuency - iter; }

                leftDiff = frecuency - iter;
                    leftDiff = Math.min(leftDiff, diff);
                    if (leftDiff < leftMinDiff) {
                        leftMinDiff = leftDiff;
                        leftBorder = iter;
                        System.out.println("leftBorder: " + leftBorder);
                    }
                diff = frecuency - iter;

            } else {
                if (i == 1) { diff = iter - frecuency; }

                rightDiff = iter - frecuency;
                    rightDiff = Math.min(rightDiff, diff);
                    if (rightDiff < rightMinDiff) {
                        rightMinDiff = rightDiff;
                        rightBorder = iter;
                        System.out.println("rightBorder: " + rightBorder);
                    }
                diff = frecuency - iter;
            }
            i++;
        }

        return String.format("\n\n\n frequency is %d \n interval from %d to %d", frecuency, leftBorder, rightBorder);
    }

    public static void main(String[] args) {
        String res = getInterval();
        System.out.println(res);
    }
}
