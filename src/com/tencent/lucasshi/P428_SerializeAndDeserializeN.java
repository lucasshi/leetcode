package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P428_SerializeAndDeserializeN {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> childString = new ArrayList<>();
        for (Node node : root.children) {
            childString.add(serialize(node));
        }
        return "(" + root.val + String.join("", childString) + ")";
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String subData = data.substring(1, data.length() - 1);
        if (subData.indexOf("(") == -1) {
            return new Node(Integer.parseInt(subData));
        }
        System.out.println("the data " + subData);
        String val = subData.substring(0, subData.indexOf("("));

        List<String> childData = new ArrayList<>();
        subData = subData.substring(subData.indexOf("("));
        int cnt = 0;
        int lstIndex = 0;
        for (int i = subData.indexOf('('); i < subData.length(); i++) {
            if (subData.charAt(i) == '(') {
                cnt += 1;
            } else if (subData.charAt(i) == ')') {
                cnt -= 1;
            }

            if (cnt == 0) {
                childData.add(subData.substring(lstIndex, i + 1));
                lstIndex = i + 1;
            }
        }
        System.out.println(childData);

        Node root = new Node();
        root.val = Integer.parseInt(val);
        for (int i = 0; i < childData.size(); i++) {
            root.children.add(deserialize(childData.get(i)));
        }
        return root;
    }

    public static void main(String[] args) {
        P428_SerializeAndDeserializeN p = new P428_SerializeAndDeserializeN();
        // Node root = p.deserialize("[12[111][112[123][1]]]");
        Node root = p.deserialize("(12(111(10)(11))(123)(122))");
        System.out.println(p.serialize(root));
    }
}
