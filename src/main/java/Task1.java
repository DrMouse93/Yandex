import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<String> answerList;

        int[] sizeInits = new int[6];

        sizeInits[0] = initAnswerLists(firstLine, secondLine, thirdLine).size();
        sizeInits[1] = initAnswerLists(secondLine, firstLine, thirdLine).size();
        sizeInits[2] = initAnswerLists(firstLine, thirdLine, secondLine).size();
        sizeInits[3] = initAnswerLists(thirdLine, firstLine, secondLine).size();
        sizeInits[4] = initAnswerLists(secondLine, thirdLine, firstLine).size();
        sizeInits[5] = initAnswerLists(thirdLine, secondLine, firstLine).size();

        int minSize = Arrays.stream(sizeInits).filter(x -> x != 0).min().getAsInt();

        System.out.println(minSize);


        /*answerList = new ArrayList<>(mergeLists(firstLine, secondLine));
        if (answerList.isEmpty()) {
            answerList = new ArrayList<>(mergeLists(secondLine, thirdLine));
            answerList = new ArrayList<>(mergeLists(answerList, firstLine));
        } else {
            answerList = new ArrayList<>(mergeLists(answerList, thirdLine));
        }

        if (answerList.isEmpty()) {
            answerList = new ArrayList<>(mergeLists(firstLine, thirdLine));
            answerList = new ArrayList<>(mergeLists(answerList, secondLine));
        }*/


        //System.out.println(answerList);
    }

    private static List<String> initAnswerLists(List<String> firstList,
                                                List<String> secondList, List<String> thirdList) {
        List<String> tempAnswer = new ArrayList<>(mergeLists(firstList, secondList));
        if (tempAnswer.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(mergeLists(tempAnswer, thirdList));
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
        int firstCount = numberMatchingValues(firstList, secondList);

        if (firstCount > 0) {
            firstList = firstList.subList(0, firstList.size() - firstCount);
            firstList.addAll(secondList);
            return firstList;
        }

        return new ArrayList<>();
    }

    private static int numberMatchingValues(List<String> firstList, List<String> secondList) {
        if (firstList.size() == 0) return 0;

        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            if (!firstList.get(i).equals(secondList.get(i)))
                return numberMatchingValues(firstList.subList(1, firstList.size()), secondList);
        }

        return firstList.size();
    }

    /*private static List<String> numberMatchingValues(List<String> firstList, List<String> secondList) {
        if (secondList.size() == 0) return new ArrayList<>();

        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            if (!firstList.get(firstList.size() - 1 - i).equals(secondList.get(i)))
                return numberMatchingValues(firstList.subList(1, firstList.size()), secondList);
        }
        return secondList;
    }*/
}
