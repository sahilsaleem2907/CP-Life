class Solution:
    def longestPalindrome(self, s: str) -> str:

        if not s:
            return ""

        s_prime = "#" + "#".join(s) + "#"
        radii = [0] * len(s_prime)

        right_border = 0
        center = 0
        max_radius = 0
        longest_center = 0

        for i in range(len(s_prime)):

            if i < right_border:
                mirror = center - (i - center)

                if radii[mirror] < right_border - i:
                    radii[i] = radii[mirror]
                    continue
                else:
                    radii[i] = right_border - i

            while i - radii[i] - 1 >= 0 \
                and i + radii[i] + 1 < len(s_prime) and s_prime[i - radii[i] - 1] == s_prime[i + radii[i] + 1]:
                radii[i] += 1

            if i + radii[i] > right_border:
                center = i
                right_border = i + radii[i]

            if radii[i] > max_radius:
                max_radius = radii[i]
                longest_center = i


        startIndex = (longest_center - max_radius) // 2

        return s[startIndex : startIndex + max_radius]
        
                



        