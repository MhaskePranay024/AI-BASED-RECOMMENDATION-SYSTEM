package com.internship;
import java.util.*;
import java.util.stream.Collectors;

public class RecommendationSystem {

    private static final Map<String, Map<String, Double>> data = new HashMap<>();

    public static void main(String[] args) {

        loadSampleData();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name (User1/User2/User3/User4): ");
        String targetUser = scanner.nextLine();


        List<String> recommendations = recommend(targetUser, 2);

        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println("- " + item);
        }
    }

    private static void loadSampleData() {
        Map<String, Double> user1 = new HashMap<>();
        user1.put("Item1", 5.0);
        user1.put("Item2", 3.0);
        user1.put("Item3", 2.5);

        Map<String, Double> user2 = new HashMap<>();
        user2.put("Item1", 2.0);
        user2.put("Item2", 2.5);
        user2.put("Item3", 5.0);
        user2.put("Item4", 2.0);

        Map<String, Double> user3 = new HashMap<>();
        user3.put("Item1", 2.5);
        user3.put("Item4", 4.0);
        user3.put("Item5", 4.5);

        Map<String, Double> user4 = new HashMap<>();
        user4.put("Item2", 3.5);
        user4.put("Item3", 4.0);
        user4.put("Item4", 4.5);
        user4.put("Item5", 5.0);

        data.put("User1", user1);
        data.put("User2", user2);
        data.put("User3", user3);
        data.put("User4", user4);
    }

    private static List<String> recommend(String user, int topN) {

        Map<String, Double> scores = new HashMap<>();

        for (String otherUser : data.keySet()) {
            if (!otherUser.equals(user)) {

                double similarity = cosineSimilarity(data.get(user), data.get(otherUser));

                for (String item : data.get(otherUser).keySet()) {
                    if (!data.get(user).containsKey(item)) {

                        double weightedScore = similarity * data.get(otherUser).get(item);
                        scores.put(item, scores.getOrDefault(item, 0.0) + weightedScore);
                    }
                }
            }
        }

        return scores.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static double cosineSimilarity(Map<String, Double> ratings1,
                                           Map<String, Double> ratings2) {

        Set<String> commonItems = new HashSet<>(ratings1.keySet());
        commonItems.retainAll(ratings2.keySet());

        if (commonItems.isEmpty()) return 0;

        double dotProduct = 0;
        double norm1 = 0;
        double norm2 = 0;

        for (String item : commonItems) {
            dotProduct += ratings1.get(item) * ratings2.get(item);
        }

        for (double r : ratings1.values()) {
            norm1 += r * r;
        }

        for (double r : ratings2.values()) {
            norm2 += r * r;
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
}
