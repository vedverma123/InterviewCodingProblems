package algoexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NGrams {

    public static void findNGrams(String line, String inputString){
        StringBuilder sb = new StringBuilder();
        if(line != null){
            String[] input = line.split(",");
            if(input.length > 0){
                int nGramLength = Integer.parseInt(input[0]);
                String userInput = input[1];

                //create word frequency map
                Map<String, Integer> frequencyMap = createMap(nGramLength, userInput, inputString);
                Map<String, Double> predictionMap = new HashMap<>();
                final Set<Map.Entry<String, Integer>> entries = frequencyMap.entrySet();
                BigDecimal total = new BigDecimal(frequencyMap.values().stream().mapToInt(Integer::intValue).sum());
                for(Map.Entry<String, Integer> entry : entries){
                    BigDecimal decimal1 = new BigDecimal(entry.getValue());
                    final BigDecimal divide = decimal1.divide(total);
                    divide.setScale(4,RoundingMode.HALF_UP);
                    predictionMap.put(entry.getKey(), divide.doubleValue());
                }

                Map<String, Double> sortedPredictionMap = new LinkedHashMap<>();

                predictionMap.entrySet().stream()
                        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                        .forEach(k -> sortedPredictionMap.put(k.getKey(),k.getValue()));

                int count = 0;
                DecimalFormat dec = new DecimalFormat("#0.000");
                for(Map.Entry<String, Double> entry : sortedPredictionMap.entrySet()){
                    sb.append(entry.getKey()).append(",").append(dec.format(entry.getValue()));
                    if(count < sortedPredictionMap.size())
                        sb.append(";");
                }
            }
        }
        System.out.println(sb.toString());
    }

    static class ValueComparator implements Comparator<Map.Entry<String, Double>> {

        private Map<String, Double> map;

        public ValueComparator(Map<String, Double> map) {
            this.map = map;
        }

        @Override
        public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2) {
            Double v1 = e1.getValue();
            Double v2 = e2.getValue();
            int result = v1.compareTo(v2);
            if (result == 0) {
                String key1 = e1.getKey();
                String key2 = e1.getKey();
                return key1.compareTo(key2);
            }
            return result;
        }
    }

    private static Map<String, Integer> createMap(int nGramLength, String userInput, String inputString) {
        final Map<String, Integer> frequencyMap = new HashMap<>();
        final String[] inputWords = inputString.replaceAll("^[.,;\\s]+", "").split("[.,;\\s]+");
        for(int count = 0; count < inputWords.length; count ++){
            String currentWord = inputWords[count];
            boolean isWordFound = false;
            if(currentWord.equalsIgnoreCase(userInput)){
                isWordFound = true;
            }
            if(isWordFound){
                int newCount = count + nGramLength - 1;
                if(newCount < inputWords.length){
                    String prediction = getPredictedWord(count, nGramLength, inputWords);
                    if(frequencyMap.get(prediction) == null){
                        frequencyMap.put(prediction,1);
                    }else{
                        frequencyMap.put(prediction,frequencyMap.get(prediction) + 1);
                    }
                }
            }
        }
        return frequencyMap;
    }

    private static String getPredictedWord(int count, int nGramLength, String[] inputWords) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < nGramLength; i ++){
            if(count + i < inputWords.length){
                sb.append(inputWords[count + i]);
                if(i < nGramLength - 1)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String inputString = "Mary had a little lamb its fleece was white as snow;\n" +
                "And everywhere that Mary went, the lamb was sure to go.\n" +
                "It followed her to school one day, which was against the rule;\n" +
                "It made the children laugh and play, to see a lamb at school.\n" +
                "And so the teacher turned it out, but still it lingered near,\n" +
                "And waited patiently about till Mary did appear.\n" +
                "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            findNGrams(line, inputString);
        }
    }

}
