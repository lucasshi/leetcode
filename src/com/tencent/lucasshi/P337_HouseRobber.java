package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/29.
 */
public class P337_HouseRobber {
    class NodeMoney {
        public int max;
        public int noNodeMax;

        public NodeMoney() {
            this.max = 0;
            this.noNodeMax = 0;
        }
    }

    public NodeMoney dfs(TreeNode root) {
        if (root == null)
            return new NodeMoney();

        // 计算节点
        NodeMoney leftMoney = dfs(root.left);
        NodeMoney rightMoney = dfs(root.right);

        NodeMoney money = new NodeMoney();
        money.noNodeMax = leftMoney.max + rightMoney.max;

        money.max = Math.max(root.val + leftMoney.noNodeMax + rightMoney.noNodeMax,
                money.noNodeMax);
        return money;
    }

    int rob(TreeNode root) {
        NodeMoney money = dfs(root);
        return money.max;
    }
}
