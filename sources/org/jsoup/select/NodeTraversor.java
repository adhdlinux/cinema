package org.jsoup.select;

import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

public class NodeTraversor {
    public static NodeFilter.FilterResult a(NodeFilter nodeFilter, Node node) {
        Node node2 = node;
        int i2 = 0;
        while (node2 != null) {
            NodeFilter.FilterResult b2 = nodeFilter.b(node2, i2);
            if (b2 == NodeFilter.FilterResult.STOP) {
                return b2;
            }
            if (b2 != NodeFilter.FilterResult.CONTINUE || node2.i() <= 0) {
                while (node2.t() == null && i2 > 0) {
                    NodeFilter.FilterResult filterResult = NodeFilter.FilterResult.CONTINUE;
                    if ((b2 == filterResult || b2 == NodeFilter.FilterResult.SKIP_CHILDREN) && (b2 = nodeFilter.a(node2, i2)) == NodeFilter.FilterResult.STOP) {
                        return b2;
                    }
                    Node C = node2.C();
                    i2--;
                    if (b2 == NodeFilter.FilterResult.REMOVE) {
                        node2.E();
                    }
                    b2 = filterResult;
                    node2 = C;
                }
                if ((b2 == NodeFilter.FilterResult.CONTINUE || b2 == NodeFilter.FilterResult.SKIP_CHILDREN) && (b2 = nodeFilter.a(node2, i2)) == NodeFilter.FilterResult.STOP) {
                    return b2;
                }
                if (node2 == node) {
                    return b2;
                }
                Node t2 = node2.t();
                if (b2 == NodeFilter.FilterResult.REMOVE) {
                    node2.E();
                }
                node2 = t2;
            } else {
                node2 = node2.h(0);
                i2++;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void b(NodeVisitor nodeVisitor, Node node) {
        Node node2 = node;
        int i2 = 0;
        while (node2 != null) {
            nodeVisitor.b(node2, i2);
            if (node2.i() > 0) {
                node2 = node2.h(0);
                i2++;
            } else {
                while (node2.t() == null && i2 > 0) {
                    nodeVisitor.a(node2, i2);
                    node2 = node2.C();
                    i2--;
                }
                nodeVisitor.a(node2, i2);
                if (node2 != node) {
                    node2 = node2.t();
                } else {
                    return;
                }
            }
        }
    }
}
