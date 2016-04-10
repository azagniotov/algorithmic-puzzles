### The Problem

Write a program that finds the word from which one can remove the most letters, one at a time,
such that each resulting word is itself a valid word. For example, you can remove six letters from "starting":

`starting => stating => statin => satin => sati => sat => at`

assuming the dictionary is:

```
at
bat
be
bee
sat
sati
satin
starting
statin
stating
```

1. The program must take the path to a dictionary as input. The dictionary will contain words, one per line.
2. The program must output the longest chains which can be created from the words in the dictionary.
3. The input is only the dictionary; the input does not include a hypothetical starting word.
4. The format must be as above with one space between each word and the following `=>` and one space after the `=>`.
5. If there are multiple words that produce equal length chains, then program prints each chain on a line by itself.
6. The program must work with large dictionaries with more than a hundred thousand words.


### Assumptions
1. Dictionary may or may not have duplicate words
2. Words are case sensitive, ie.: "Alex" and "alex" considered to be different words
3. Dictionary may or may not have single-letter words
4. "Longest" word chain is determined by the number of words in a chain. Length of words in a chain does not affect the total chain length,
ie: word chain `alexey -> lexey -> exey` is of the same length as `even -> ven -> en`


### Design Decisions
1. Single-letter words are not considered to be valid words
2. In order to build relationship between words and their sub-words, the dictionary is computed into a tree. The `Graph` class responsible for constructing the tree. The `Node` class represent a node in a tree.
3. The `Chain` class represents a word chain. Word chains are computed as tree is being built and word chains are stored by length in a map
4. Top level leafs are not added. This makes the tree size smaller and prevents single word chains to be created.


### Algorithm Optimizations
1. Duplicate dictionary words are not considered
2. Duplicate word chains are not considered: `'boot' -> 'oot', 'bot', 'bot', 'boo': we have 'bot' twice`
3. If a word was processed a child of some parent, then there no need to re-process this word again as a head of new chain. This avoids from re-creating shorter chains
4. There is no tree traversal or sorting steps involved in order to identify longest word chains. Longest chains are identified as tree is being built


### Big O Complexity Analysis
In order to make Big O complexity analysis easier, the program is broken down into several parts and each part is analyzed separately:

1. Reading dictionary from the local filesystem and loading it into memory has `O(N)` performance, where `N` is the number of words
2. Constructing word chains from the collection of words has `O(L * N)`, where `L` is an average word length and `N` is the number of words
3. Retrieving longest word chains has `O(1)`, since all word chains are stored in a map having their length as map keys. Longest chain length is always known
4. Printing word chains has `O(H)` performance, where `H` is the number of word chains


### Load Testing
The solution has been tested on the following hardware against a dictionary with `354,982` unique English words from `input/354982.txt`:

1. Loading the dictionary took: ~ `0 sec, 230 millis`
2. Computing word tree and longest chains took: ~ `1 sec, 600 millis`

```
Processor  2.2 GHz Intel Core i7
Memory  8 GB 1333 MHz DDR3
Software  Mac OS X Lion 10.7.5 (11G63)
Darwin Kernel Version 11.4.2: root:xnu-1699.32.7~1/RELEASE_X86_64
Java(TM) SE Runtime Environment (build 1.7.0_76-b13)
Java HotSpot(TM) 64-Bit Server VM (build 24.76-b04, mixed mode)
```

### Building
No Java build libraries (Ant, Maven, Gradle) are required to build the program. Building is done using
the `build.sh` file, which compiles sources and creates an executable JAR

1. Open shell window
2. Navigate to the root of `linguistic-chains` directory where the current README is, ie.: `linguistic-chains/`
3. Execute `build.sh` by running the command `sh build.sh`
4. Find the generated `linguistic-chains-1.0.0.jar` in the current directory, ie.: `linguistic-chains/linguistic-chains-1.0.0.jar`


### Executing
1. Make sure you have successfully built `linguistic-chains-1.0.0.jar` (see `Building` section)
2. Make sure you under the root of `linguistic-chains` directory where the current README is, ie.: `linguistic-chains/`
3. Put the input file in the directory where the generated JAR is, ie.: `linguistic-chains/<INPUT_FILE_NAME>`
4. Execute the command `java -jar linguistic-chains-1.0.0.jar <INPUT_FILE_NAME>`
5. Input file path should be relative to `linguistic-chains` directory, ie.: both ways are fine:
(a) `java -jar linguistic-chains-1.0.0.jar input.txt`
(b) `java -jar linguistic-chains-1.0.0.jar input/unix.txt`


##### Input Files
Located under `input` directory:

1. Words from `usr/share/dict/words`: `unix.txt`
2. Dictionary with 354,982 unique English words: `354982.txt`


### Testing
1. Make sure you under the root of `linguistic-chains` directory where the current README is, ie.: `linguistic-chains/`
2. Execute `test.sh` by running the command `sh test.sh`