# AI-BASED-RECOMMENDATION-SYSTEM

**COMPANY** : CODTECH IT SOLUTIONS

**NAME** :   MHASKE PRANAY SURESH

**INTERN ID**: CTIS3600

**DOMAIN** : JAVA PROGRAMMING

**BATCH DURATION** : 4 WEEKS

**MENTOR NAME** : NEELA SANTOSH

# ENTER DESCRIPTION OF TASK PERFORMED NOT LESS THAN 500 WORDS

As part of Internship Task-4, an AI-Based Recommendation System was successfully designed and implemented using Java. The objective of this task was to build a working recommendation engine capable of suggesting products or items to users based on their preferences using collaborative filtering techniques. The system was developed entirely using core Java libraries without relying on external frameworks, demonstrating a clear understanding of recommendation logic and similarity algorithms.

The implemented system follows a **User-Based Collaborative Filtering** approach. In this approach, recommendations are generated for a target user by analyzing the preferences of other users with similar tastes. The program uses a nested `HashMap` data structure to store user-item ratings. A static map named `data` stores all user information, where each user (e.g., User1, User2, User3, User4) is associated with another map containing item names and their respective ratings.

The `loadSampleData()` method initializes the dataset. It creates rating profiles for four users with different ratings for five items (Item1 to Item5). These ratings represent user preferences and serve as sample data for the recommendation engine. This structured storage allows efficient lookup and comparison of user preferences.

The execution of the program begins in the `main()` method. The system prompts the user to enter a username (User1/User2/User3/User4). After receiving input, the system calls the `recommend()` method to generate personalized recommendations for the selected user. The program is designed to return the top N recommendations (in this case, 2 items).

The recommendation process works as follows:

1. **Similarity Calculation:**
   For the target user, the system compares their ratings with every other user in the dataset. It calculates similarity scores using the **Cosine Similarity** algorithm. The cosine similarity is computed in the `cosineSimilarity()` method.

2. **Finding Common Items:**
   The method first identifies common items rated by both users using a `HashSet` intersection operation. If no common items exist, the similarity score is returned as zero.

3. **Dot Product and Norm Calculation:**
   The dot product of ratings for common items is calculated. Then, the magnitude (norm) of each user’s rating vector is computed by summing the squares of their ratings and taking the square root.

4. **Similarity Formula:**
   The cosine similarity formula used is:

   similarity = dotProduct / (sqrt(norm1) × sqrt(norm2))

   This produces a value between 0 and 1, where higher values indicate stronger similarity between users.

5. **Weighted Score Calculation:**
   After computing similarity with other users, the system identifies items that similar users have rated but the target user has not rated. For each such item, a weighted score is calculated:

   weightedScore = similarity × otherUserRating

   These weighted scores are accumulated in a `scores` map.

6. **Sorting and Selecting Top Recommendations:**
   The system then sorts the items in descending order based on their accumulated weighted scores using Java Streams and lambda expressions. The top N items (top 2 in this case) are selected and returned as recommendations.

Finally, the recommended items are displayed to the user in a clean output format.

This implementation demonstrates several important programming and AI concepts:

* Use of Java Collections (`HashMap`, `HashSet`)
* Implementation of cosine similarity algorithm
* User-based collaborative filtering logic
* Functional programming using Java Streams
* Sorting and ranking mechanisms
* Data aggregation and weighted scoring

The system successfully fulfills the internship requirement of building a working recommendation engine with sample data. It is modular, easy to understand, and can be extended in the future by adding file-based input, database connectivity, GUI interface, or integration with advanced machine learning libraries such as Apache Mahout.

Overall, this task provided hands-on experience in implementing artificial intelligence concepts using Java. The developed recommendation system demonstrates how personalized recommendations can be generated efficiently based on user similarity, similar to real-world applications like Amazon, Netflix, and Spotify.

# OUTPUT OF THE TASK

<img width="1568" height="953" alt="Image" src="https://github.com/user-attachments/assets/60c0930b-9d8d-4780-873a-947685160a47" />
<img width="1570" height="937" alt="Image" src="https://github.com/user-attachments/assets/b2fa2414-fa55-4e20-8492-ea3f6d59e6f3" />

