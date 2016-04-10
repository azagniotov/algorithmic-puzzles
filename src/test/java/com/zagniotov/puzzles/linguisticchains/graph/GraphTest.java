package com.zagniotov.puzzles.linguisticchains.graph;


import com.zagniotov.puzzles.linguisticchains.io.InputReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GraphTest {

    @Test
    public void shouldBuildSingleChainList_WhenSingleWordProvided() throws Exception {
        final Graph graph = buildGraphWithWords("grapes");
        final List<String> chains = graph.compute();

        assertEquals(1, chains.size());
    }

    @Test
    public void shouldBuildSingleChain_WhenTwoWordsGiven() throws Exception {
        final Graph graph = buildGraphWithWords("grapes", "rapes");
        final List<String> chains = graph.compute();

        assertEquals(1, chains.size());
        assertTrue(chains.contains("grapes => rapes"));
    }

    @Test
    public void shouldComputeSingleLongestChain_WhenMultipleWordsGive() throws Exception {
        // grapes -> rapes -> apes -> pes
        final Graph graph = buildGraphWithWords("grapes", "rapes", "apes", "pes");
        final List<String> chains = graph.compute();

        assertEquals(1, chains.size());
        assertTrue(chains.contains("grapes => rapes => apes => pes"));
    }

    @Test
    public void shouldComputeMultipleLongestChains_WhenMultipleWordsGive() throws Exception {
        // grapes \
        //          rapes -> apes -> pes
        // frapes /
        final Graph graph = buildGraphWithWords("grapes", "frapes", "rapes", "apes", "pes");
        final List<String> chains = graph.compute();

        assertEquals(2, chains.size());
        assertTrue(chains.contains("grapes => rapes => apes => pes"));
        assertTrue(chains.contains("frapes => rapes => apes => pes"));
    }

    @Test
    public void shouldBuildUniqueWordChains() throws Exception {
        // To avoid: 'bee' -> 'be', 'ee', 'be': we have 'be' twice
        final Graph graph = buildGraphWithWords("bee", "be");
        final List<String> chains = graph.compute();

        assertEquals(1, chains.size());
        assertTrue(chains.contains("bee => be"));
    }

    @Test
    public void shouldAllowCaseSensitiveWordChains() throws Exception {
        final Graph graph = buildGraphWithWords("Alex", "alex", "lex");
        final List<String> chains = graph.compute();

        assertEquals(2, chains.size());
        assertTrue(chains.contains("Alex => lex"));
        assertTrue(chains.contains("alex => lex"));
    }

    @Test
    public void shouldNotCreateTopLevelNodes_WhenTopLevelNodeAlsoTheLeafNode() throws Exception {
        // orange -> range
        // ex
        final Graph graph = buildGraphWithWords("orange", "range", "ex");
        final List<String> chains = graph.compute();

        assertEquals(1, chains.size());
        assertTrue(chains.contains("orange => range"));
    }

    @Test
    public void shouldNotAddProcessedWordsAsTopLevelNodes_WhenProcessedWordHasParent() throws Exception {
        final Graph graph = buildGraphWithWords("starting", "stating", "statin", "satin");
        final Node root = graph.constructTree();

        assertEquals(1, root.getChildren().size());
    }

    @Test
    public void shouldCalculateCorrectNumberOfChildren_WhenTwoDifferentParentHaveSameSubBranch() throws Exception {
        // alabama \
        //          labama -> abama -> bama
        // blabama /
        final Graph graph = buildGraphWithWords("alabama", "blabama", "labama", "abama", "bama");
        final Node root = graph.constructTree();

        assertEquals(2, root.getChildren().size());
    }

    @Test
    public void shouldCalculateCorrectNumberOfChildren_WhenSameParentHasDifferentSubBranches() throws Exception {
        //                      / panoram -> panora
        // apanorama -> panorama
        //                      \ anorama -> norama -> orama
        //                                          \
        //                                           norma -> norm
        final Graph graph = buildGraphWithWords("apanorama", "panorama", "panoram", "anorama", "panora", "norama", "orama", "norma", "norm");
        final Node root = graph.constructTree();

        assertEquals(1, root.getChildren().size());
        assertEquals(1, root.getChildren().get(0).getChildren().size());
        assertEquals(2, root.getChildren().get(0).getChildren().get(0).getChildren().size());
    }

    @Test
    public void shouldComputeSingleLongestChain_WhenComplexTree() throws Exception {
        //                      / panoram -> panora
        // apanorama -> panorama
        //                      \ anorama -> norama -> orama
        //                                          \
        //                                           norma -> norm
        final Graph graph = buildGraphWithWords("apanorama", "panorama", "panoram", "anorama", "panora", "norama", "orama", "norma", "norm");
        final List<String> chains = graph.compute();

        assertEquals(1, chains.size());
        assertEquals("apanorama => panorama => anorama => norama => norma => norm", chains.get(0));
    }

    private Graph buildGraphWithWords(final String... words) throws IOException {

        final StringBuilder builder = new StringBuilder();
        for (final String word : words) {
            builder.append(word).append(System.lineSeparator());
        }

        final InputStream is = new ByteArrayInputStream(builder.toString().getBytes(InputReader.DEFAULT_CHARSET));
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        return new Graph(InputReader.populateWordsByLength(bufferedReader));
    }
}
