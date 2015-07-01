package com.radar.interview.hashtable;

import com.radar.interview.InterviewProblem;

import java.util.*;

/**
 * Created by radar on 5/12/15.
 */
public class ShortestSubarrayCoveringSet implements InterviewProblem {

    public static String randString(int len) {
        StringBuilder sb = new StringBuilder();
        Random gen = new Random();
        while (len-- != 0) {
            sb.append((char) (gen.nextInt('z' + 1 - 'a') + 'a'));
        }
        return sb.toString();
    }

    // @include
    public static Pair<Integer, Integer> findSmallestSubarrayCoveringSet(
            String[] paragraph, Set<String> keywords) {
        Map<String, Integer> keywordsToCount = new HashMap<>();
        int left = 0, right = 0;
        Pair<Integer, Integer> result = new Pair<>(-1, -1);
        while (right < paragraph.length) {
            // Keeps advancing right until it reaches end or keywordsToCount has
            // all keywords.
            while (right < paragraph.length
                    && keywordsToCount.size() < keywords.size()) {
                if (keywords.contains(paragraph[right])) {
                    keywordsToCount.put(paragraph[right],
                            keywordsToCount.containsKey(paragraph[right])
                                    ? keywordsToCount.get(paragraph[right]) + 1 : 1);
                }
                ++right;
            }

            // Found all keywords.
            if (keywordsToCount.size() == keywords.size() &&
                    ((result.first == -1 && result.second == -1)
                            || right - 1 - left < result.second - result.first)) {
                result.first = left;
                result.second = right - 1;
            }

            // Keeps advancing left until it reaches end or keywordsToCount does not
            // have all keywords.
            while (left < right && keywordsToCount.size() == keywords.size()) {
                if (keywords.contains(paragraph[left])) {
                    int keywordCount = keywordsToCount.get(paragraph[left]);
                    keywordsToCount.put(paragraph[left], --keywordCount);
                    if (keywordCount == 0) {
                        keywordsToCount.remove(paragraph[left]);
                        if ((result.first == -1 && result.second == -1)
                                || right - 1 - left < result.second - result.first) {
                            result.first = left;
                            result.second = right - 1;
                        }
                    }
                }
                ++left;
            }
        }
        return result;
    }
    
    private static class Pair<T,U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    @Override
    public void runExample() {

        Random gen = new Random();
        for (int times = 0; times < 10; ++times) {
            int n;

            n = gen.nextInt(10) + 1;

            String[] A = new String[n];
            for (int i = 0; i < n; ++i) {
                A[i] = randString(gen.nextInt(10) + 1);
            }
      /*
       * for (int i = 0; i < A.size(); ++i) { cout << A[i] << ' '; } cout <<
       * endl;
       */
            Set<String> dict = new HashSet<>(Arrays.asList(A));
            int m = gen.nextInt(dict.size()) + 1;
            String[] Q = new String[m];
            int idx = 0;
            for (String aDict : dict) {
                Q[idx++] = aDict;
                if (--m == 0) {
                    break;
                }
            }

      /*
       * for (int i = 0; i < Q.size(); ++i) { cout << Q[i] << ' '; } cout <<
       * endl;
       */

            dict = new HashSet<>(Arrays.asList(Q));
            Pair<Integer, Integer> res = findSmallestSubarrayCoveringSet(A, dict);
            System.out.println(res.first + ", " + res.second);
            dict.clear();
            for (String aQ1 : Q) {
                dict.add(aQ1);
            }
            for (int i = res.first; i <= res.second; ++i) {
                if (dict.contains(A[i])) {
                    dict.remove(A[i]);
                }
            }
            assert (dict.isEmpty());
        }

    }
}
