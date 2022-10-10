import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstLine;
        List<String> secondLine;
        List<String> thirdLine;

        firstLine = fillList(scanner);
        secondLine = fillList(scanner);
        thirdLine = fillList(scanner);

        System.out.println(secondLine.contains("2"));

        List<String> answerList;

        answerList = new ArrayList<>(mergeLists(firstLine, secondLine));
        if (answerList.isEmpty()) {
            answerList = new ArrayList<>(mergeLists(secondLine, thirdLine));
            answerList = new ArrayList<>(mergeLists(answerList, firstLine));
        } else {
            answerList = new ArrayList<>(mergeLists(answerList, thirdLine));
        }

        if (answerList.isEmpty()) {
            answerList = new ArrayList<>(mergeLists(firstLine, thirdLine));
            answerList = new ArrayList<>(mergeLists(answerList, secondLine));
        }


        System.out.println(answerList);
    }

    private static List<String> fillList(Scanner scanner) {
        int size = scanner.nextInt();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scanner.next());
        }

        return list;
    }

    private static List<String> mergeLists(List<String> firstList, List<String> secondList) {
        /*int firstCount = numberMatchingValues(firstList, secondList);
        int secondCount = numberMatchingValues(secondList, firstList);*/

        if (!numberMatchingValues(firstList, secondList).isEmpty()) {
            firstList.addAll(numberMatchingValues(firstList, secondList));
            return firstList;
        } else if (!numberMatchingValues(secondList, firstList).isEmpty()) {
            secondList.addAll(numberMatchingValues(secondList, firstList));
            return secondList;
        }

        return new ArrayList<>();
    }

    /*private static int numberMatchingValues(List<String> firstList, List<String> secondList) {
        int count = 0;

        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            if (firstList.get(firstList.size() - 1 - count).equals(secondList.get(count))) {
                count++;
            } else {
                break;
            }
        }
         return count;
    }*/

    private static List<String> numberMatchingValues(List<String> firstList, List<String> secondList) {
        if (secondList.size() == 0) return new ArrayList<>();
        return firstList.contains(secondList) ? secondList :
                numberMatchingValues(firstList, secondList.subList(0, secondList.size() - 1));
    }
}
