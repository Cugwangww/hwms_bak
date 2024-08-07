package com.ebg.N叉树.N叉树的后序遍历;

import com.ebg.N叉树.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author author
 * @Date 2024/3/20 22:21
 */

public class Solution {

    /**
     * https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/
     *
     * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[5,6,3,2,4,1]
     *
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        help(root,list);
        return list;
    }

    private void help(Node root, List<Integer> list) {
        if(root ==null){
            return;
        }
        for (Node node : root.children) {
            help(node,list);
        }
        list.add(root.val);
    }
}
