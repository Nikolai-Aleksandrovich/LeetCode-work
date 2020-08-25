import java.util.Arrays;
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
class Solution {
     public boolean repeatedSubstringPattern(String s) {
         int n = s.length();
         for (int i = 1; i * 2 <= n; i++) {
             if (n % i == 0) {
                 boolean match = true;
                 for (int j = i; j < n; j++) {
                     if (s.charAt(j) != s.charAt(j - i)) {
                         match = false;
                     }
                 }
                 if (match) {
                     return true;
                 }
             }
         }
         return false;
         //return (s + s).indexOf(s, 1) != s.length();s+s中s再次出现的位置必然是s的长度    }

     }
 }
 class KMPWaySolution {
     public boolean repeatedSubstringPattern(String s) {
         return kmp(s + s, s);//输入字符串s
     }

     public boolean kmp(String query, String pattern) {
         int n = query.length();
         int m = pattern.length();
         int[] fail = new int[m];//名为fail大小为m
         Arrays.fill(fail, -1);//fail=[-1,-1,-1,-1,-1,-1]
         for (int i = 1; i < m; ++i) {
             int j = fail[i - 1];//j=-1
             while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                 j = fail[j];
             }
             if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                 fail[i] = j + 1;
             }
         }
         int match = -1;
         for (int i = 1; i < n - 1; ++i) {
             while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                 match = fail[match];
             }
             if (pattern.charAt(match + 1) == query.charAt(i)) {
                 ++match;
                 if (match == m - 1) {
                     return true;
                 }
             }
         }
         return false;
     }
 }
class KMP_String_Matching {
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
}


