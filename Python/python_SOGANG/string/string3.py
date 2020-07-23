sample = "abcABCdEFaBCDeFAbC"
sample_lower = sample.lower()
index_abc = sample_lower.find("abc")
count_abc = sample_lower.count("abc")
index_def = sample_lower.find("def")
count_def = sample_lower.count("def")

print("abc 문자열 : %d 인덱스, %d번 존재"
      % (index_abc, count_abc))
print("def 문자열 : %d 인덱스, %d번 존재"
      % (index_def, count_def))
