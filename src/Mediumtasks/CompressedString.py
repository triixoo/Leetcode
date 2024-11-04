class Solution:
    def compressedString(self, word: str) -> str:
        comp = ""
        i = 0

        while i < len(word):
            c = word[i]  # The current character
            count = 0

            # Count the number of consecutive occurrences of c, limited to 9
            while i < len(word) and word[i] == c and count < 9:
                count += 1
                i += 1

            # Append the count and character to the compressed string
            comp += str(count) + c

        return comp

# Example usage:
solution = Solution()
print(solution.compressedString("abcde"))            # Output: "1a1b1c1d1e"
print(solution.compressedString("aaaaaaaaaaaaaabb"))  # Output: "9a5a2b"
