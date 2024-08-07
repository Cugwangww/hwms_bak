package com.ebg.N叉树;

import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/21
 */
public class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
