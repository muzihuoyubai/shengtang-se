
#### 1. 为二进制字符串开发正则表达式
```
应该匹配成功
0
1
00
10
111010101010111
应该匹配失败
cat
123
he110, w0r1d
```

#### 2. 为任何表示偶数的无符号二进制字符串开发一个正则表达式
```
应该匹配成功
0
10
1110
010
00011000110110
应该匹配失败
1
011
0101
0001101
```

#### 3. 为任何偶数长度的二进制字符串开发正则表达式
```
应该匹配成功
00
01
1010
0001
0001101100011011
应该匹配失败
0
1
111
010
0001101
```

#### 4. 为任何包含模式0110或模式1001的二进制字符串开发一个正则表达式
```
应该匹配成功
0110
1001
01101001
011001
111101101111
0000010010000
应该匹配失败
0
1
0101
1010
1100010001110
```

#### 5. 为任何包含模式0110和模式1001的二进制字符串开发正则表达式(同时包含)
```
应该匹配成功
01101001
000110001001000
011001
100110
000011001000
应该匹配失败
0
1
0110
1001
01101
10010
1100010001110
```

#### 6. 识别以下几个正则表达式表示的字符串类型，并给出一些测试字符串（包括匹配成功和匹配失败的例子各3个）:

```
[A-Z][0-9][A-Z]\s[0-9][A-Z][0-9]
([0-9]|[A-F])+
(\(\d\d\d\)\s)?\d\d\d-\d\d\d\d
```

#### 7. 开发一个正则表达式，它将接受以下三个字符串: {"pickup truck", "pick up truck", "pick-up truck"}

```
应该匹配成功
pickup truck
pick up truck
pick-up truck
应该匹配失败
pickuptruck
pick.up.truck
pick- up truck
pick -up truck
volkswagon
```

#### 8. 开发一个正则表达式，它可以接受三个或四个单词

```
应该匹配成功
one two three
one two three four
1 2 3 4
how many words?
应该匹配失败
word
word word
word word word word word
```

#### 9. 开发一个正则表达式，匹配24小时格式的时间字符串(0:00…23:59)
应该匹配成功
12:34
0:00
23:59
9:00
10:00
11:11
15:15
应该匹配失败
24:00
0:60
9:99
04:00
4
-4:00

#### 10. 
DNA序列由符号{A,C,G,T}组成。三个连续的字母被称为密码子，所以ACT和TCG都是密码子。一个基因组合至少包含三个密码子，它们以ATG密码子开始，以TAA、TAG或TGA密码子结束。

开发一个正则表达式来匹配基因字符串。
```
应该匹配成功
ATGCCCTAA
ATGCCCTAG
ATGCCCTGA
CATGCCCTAA
CATGCCCTAG
CATGCCCTGA
CATGCCCTAAC
CATGCCCTAGC
CATGCCCTGAT
TCATGCCCTGACC
TTATGCCCGGGTGACC
AAACTCATGCCCGGGCCCTGACCTTAA
ATGATGATGTAA
ATGAAAAACAAGAATTAA
ATGACAACCACGACTTAA
ATGAGAAGCAGGAGTTAA
ATGATAATCATGATTTAA
ATGCAACACCAGCATTAA
ATGCCACCCCCGCCTTAA
ATGCGACGCCGGCGTTAA
ATGCTACTCCTGCTTTAA
ATGGAAGACGAGGATTAA
ATGGCAGCCGCGGCTTAA
ATGGGAGGCGGGGGTTAA
ATGGTAGTCGTGGTTTAA
ATGTACTATTCATCCTCGTCTTGCTGGTGTTTATTCTTGTTTTAA
应该匹配失败
GATTACA
ATGTAA
ATGTAG
ATGTGA
ATGCCCCTAG
ATGCCCCCTAG
CCCATGCCCCTAGCCC
CCCATGCCCCCTAGCCC
```

#### 11. 开发匹配金额的正则表达式。

```
应该匹配成功
$0
$0.00
$0.99
$4
$4.00
$10
$10.00
$1000
$1000.00
$1,000
$1,000.00
$8,888,888,888,888.88
$88,888,888,888,888.88
$888,888,888,888,888.88
$1234567.89
应该匹配失败
$-0
$ 0
$1.9
$.99
bannana
$,333.33
$12,34
$22,333,22,333.22
$$$
$$$0
3$
```