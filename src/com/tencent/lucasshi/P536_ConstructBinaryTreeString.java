package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fzy on 17/9/21.
 */
public class P536_ConstructBinaryTreeString {
    public static final int TYPE_NODE = 1;
    public static final int TYPE_BRACKET = 2;

    class Element {
        public TreeNode node;
        public int elementType;

        public Element(TreeNode node) {
            this.node = node;
            this.elementType = TYPE_NODE;
        }

        public Element() {
            this.elementType = TYPE_BRACKET;
        }
    }

    public void printStack(Stack<Element> stack) {
        for (Element e : stack) {
            if (e == null) {
                System.out.print("null ");
            } else if (e.elementType == TYPE_BRACKET) {
                System.out.print("( ");
            } else {
                System.out.print(e.node.val + " ");
            }
        }
        System.out.println();
    }

    public TreeNode str2treeV1(String s) {
        Stack<Element> nodeStack = new Stack<>();

        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(s.charAt(i) + " " + i);
            printStack(nodeStack);
            if (s.charAt(i) == '(') {
                if (tmp.length() != 0) {
                    TreeNode node = new TreeNode(Integer.valueOf(tmp));
                    nodeStack.push(new Element(node));
                }
                nodeStack.push(new Element());
                tmp = "";
                continue;
            }

            if (s.charAt(i) == ')') {
                if (tmp.length() != 0) {
                    TreeNode node = new TreeNode(Integer.valueOf(tmp));
                    nodeStack.push(new Element(node));
                }
                tmp = "";
                // pop stack
                ArrayList<Element> elements = new ArrayList<>();
                while (!nodeStack.empty()) {
                    Element e = nodeStack.pop();
                    if (e != null && e.elementType == TYPE_BRACKET) {
                        break;
                    }
                    elements.add(e);
                }

                if (elements.size() == 3) {
                    Element right = elements.get(0);
                    Element left = elements.get(1);
                    Element root = elements.get(2);
                    root.node.left = left.node;
                    root.node.right = right.node;
                    nodeStack.push(root);
                }

                if (elements.size() == 2) {
                    Element left = elements.get(0);
                    Element root = elements.get(1);
                    root.node.left = left.node;
                    nodeStack.push(root);
                }

                if (elements.size() == 0) {
                    nodeStack.push(new Element(null));
                }

                if (elements.size() == 1) {
                    nodeStack.push(elements.get(0));
                }

                continue;
            }
            tmp += s.charAt(i);
        }
        printStack(nodeStack);

        if (nodeStack.size() == 1) {
            return nodeStack.pop().node;
        }

        if (nodeStack.size() == 2) {
            TreeNode left = nodeStack.pop().node;
            TreeNode root = nodeStack.pop().node;
            root.left = left;
            return root;
        }

        if (nodeStack.size() == 3) {
            TreeNode right = nodeStack.pop().node;
            TreeNode left = nodeStack.pop().node;
            TreeNode root = nodeStack.pop().node;
            root.left = left;
            root.right = right;
            return root;
        }

        return null;
    }


    public TreeNode str2String(String s) {
        if (s.length() == 0)
            return null;

        if (s.indexOf('(') == -1) {
            return new TreeNode(Integer.valueOf(s));
        }

        int rootVal = Integer.valueOf(s.substring(0, s.indexOf('(')));
        TreeNode root = new TreeNode(rootVal);

        int startPtr = s.indexOf('(');
        int ptr = startPtr;
        int endPtr = ptr;
        int count = 0;
        for (; ptr != s.length(); ptr++) {
            if (s.charAt(ptr) == '(') {
                count++;
            }

            if (s.charAt(ptr) == ')') {
                count--;
            }

            if (count == 0) {
                endPtr = ptr;
                break;
            }
        }

        String leftStr = s.substring(startPtr + 1, endPtr);
        String rightStr = "";
        if (endPtr + 2 < s.length() - 1) {
            rightStr = s.substring(endPtr + 2, s.length() - 1);
        }

        root.left = str2String(leftStr);
        root.right = str2String(rightStr);
        return root;
    }


    public static void main(String[] args) {
        P536_ConstructBinaryTreeString p = new P536_ConstructBinaryTreeString();
        //p.str2treeV1("4(2(3)(1))(6(5))");

        String s = "4(2(3)(1))(6(5))";
        String s1 = "4()(1)";
        // System.out.println(Integer.valueOf(s.substring(0, s.indexOf('('))));
        // System.out.println(s.substring(2, 9));
        // System.out.println(s.substring(10, s.length() - 1));

        p.str2String(s);
        p.str2String(s1);


    }
}
