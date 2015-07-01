package com.radar.interview.graph;

import com.radar.interview.InterviewProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radar on 5/5/15.
 */
public class GoogleEncode implements InterviewProblem {

    public void encode(String str) {

        List<Vertex> list = genGraph(str);
        printEncodings(list, list.get(0), new StringBuilder("c"));

    }

    private void printEncodings(List<Vertex> list, Vertex curVert, StringBuilder b) {
        if (curVert.edges.size() == 0) {
            System.out.println(b.toString());
            return;
        }

        for (Edge edge : curVert.edges) {
            b.append(edge.cost == 0 ? String.valueOf(edge.dest.value) : edge.cost + String.valueOf(edge.dest.value));
            printEncodings(list, edge.dest, b);
            b.setLength(b.length() - 1);

            // If we have removed an alpha char but there's still a digit to remove...
            if (Character.isDigit(b.charAt(b.length() - 1))) {
                b.setLength(b.length() - 1);
            }
        }

    }

    private List<Vertex> genGraph(String str) {

        if (str == null || str.length() == 0) {
            return null;
        }

        List<Vertex> results = new ArrayList<>();
        Vertex vert = new Vertex(str.charAt(0));

        int i = 0;
        
        for (i = 0; i < str.length() - 1; i++) {
            Vertex nextVert = new Vertex(str.charAt(i + 1));
            vert.edges.add(new Edge(nextVert, 0));
            results.add(vert);
            vert = nextVert;
        }

        results.add(vert);

        i = 0;
        int j;
        
        while (i < str.length() - 1) {

            List<Edge> curEdges = results.get(i).edges;
            j = i + 2;

            while (j < str.length()) {
                curEdges.add(new Edge(results.get(j), j - i - 1));
                j++;
            }
            i++;
        }

        return results;
    }

    private class Vertex {
        List<Edge> edges = new ArrayList<>();
        char value = '0';

        Vertex(char value) {
            this.value = value;
        }
    }

    private class Edge {
        Vertex dest;
        int cost;

        Edge(Vertex dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }


    @Override
    public void runExample() {

        encode("clean");

    }
}
