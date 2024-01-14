def close_strings(word1, word2):
    if len(word1) != len(word2):
        return False

    freq_map1 = get_character_frequency_map(word1)
    freq_map2 = get_character_frequency_map(word2)

    chars1 = ''.join(sorted(freq_map1.keys()))
    chars2 = ''.join(sorted(freq_map2.keys()))

    freqs1 = ''.join(map(str, sorted(freq_map1.values())))
    freqs2 = ''.join(map(str, sorted(freq_map2.values())))

    return chars1 == chars2 and freqs1 == freqs2

def get_character_frequency_map(word):
    freq_map = {}
    for char in word:
        freq_map[char] = freq_map.get(char, 0) + 1
    return freq_map

# Example usage:
word1 = "cabbba"
word2 = "abbccc"
result = close_strings(word1, word2)
print(result)  # Output: True