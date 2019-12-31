package com.battle.algorithm4;

class TreeNode {
    final static int MAX_SIZE = 26;
    char data;//表示当前结点存的字母
    boolean isEnd = false;//表示是否为叶子结点
    TreeNode[] childs;

    public TreeNode() {
        childs = new TreeNode[MAX_SIZE];
        isEnd = false;
    }
}

/**
 * 字典树
 */
public class TireTree {

    public static void createTireTree(TreeNode node, String str) {
        //ascii A=>65 a=>97
        char[] d = str.toCharArray();
        for (int i = 0; i < d.length; i++) {
            int loc = d[i] - 'a';   //转换成0~25之间的数字，一个小技巧
            if (node.childs[loc] == null) {
                node.childs[loc] = new TreeNode();
                node.childs[loc].data = d[i];
            }
            node = node.childs[loc];
        }
        node.isEnd = true;
    }

    public static boolean find(String str, TreeNode node) {
        char[] d = str.toCharArray();
        for (int i = 0; i < d.length; i++) {
            char loc = d[i] = 'a';
            if (node.childs[loc] != null) {
                node = node.childs[loc];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        String[] s = {"java", "ps", "php", "ui", "css", "js"};
        TreeNode root = new TreeNode();
        for (String ss : s) {
            createTireTree(root, ss);
        }

        System.out.println("数据插入完成!");
        System.out.println(find("java", root));
        System.out.println(find("jav ", root));//找前缀自动补全
    }

}

