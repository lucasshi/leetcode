package com.tencent.lucasshi;

import java.util.ArrayList;

/**
 * Created by fzy on 17/9/4.
 */
public class Amazon_CommonManager_done {
    static class Employee {
        public int id;
        public String name;
        public ArrayList<Employee> reports;

        public Employee(int id) {
            this.id = id;
            this.reports = new ArrayList<>();
        }
    }

    public ArrayList<Employee> findPath(Employee node, Employee emp) {
        ArrayList<Employee> result = new ArrayList<>();
        if (node == emp) {
            result.add(node);
            return result;
        }

        // other
        if (node.reports.size() == 0)
            return null;

        for (int i = 0; i < node.reports.size(); i++) {
            ArrayList<Employee> subResult = findPath(node.reports.get(i), emp);
            if (subResult != null) {
                subResult.add(node);
                return subResult;
            }
        }

        return null;
    }

    public Employee findCommonManager(Employee ceo, Employee emp1, Employee emp2) {
        ArrayList<Employee> path1 = findPath(ceo, emp1);
        ArrayList<Employee> path2 = findPath(ceo, emp2);


        int sameIndex = 0;
        if (path1 == null || path2 == null)
            return null;

        for (sameIndex = 0; sameIndex < path1.size() && sameIndex < path2.size(); sameIndex++) {
            Employee pointer1 = path1.get(path1.size() - 1 - sameIndex);
            Employee pointer2 = path2.get(path2.size() - 1 - sameIndex);

            if (pointer1 != pointer2)
                break;
        }

        if (path1.get(path1.size() - sameIndex) == ceo) {
            return null;
        }

        return path1.get(path1.size() - sameIndex);
    }

    public static void main(String[] args) {
        Amazon_CommonManager_done amazon_commonManager_done = new Amazon_CommonManager_done();
        Employee ceo = new Employee(1);
        Employee emp2 = new Employee(2);
        Employee emp3 = new Employee(3);
        Employee emp4 = new Employee(4);
        Employee emp5 = new Employee(5);
        Employee emp6 = new Employee(6);
        Employee emp7 = new Employee(7);
        Employee emp8 = new Employee(8);

        // do

        ceo.reports.add(emp2);
        ceo.reports.add(emp3);

        emp2.reports.add(emp4);
        emp2.reports.add(emp5);
        emp4.reports.add(emp7);

        emp3.reports.add(emp6);

        System.out.println(amazon_commonManager_done.findCommonManager(ceo, emp7, emp5).id);
        System.out.println(amazon_commonManager_done.findCommonManager(ceo, emp4, emp3) == null ? -1:
                amazon_commonManager_done.findCommonManager(ceo, emp4, emp3).id);
        System.out.println(amazon_commonManager_done.findCommonManager(ceo, emp8, emp3) == null ? -1:
                amazon_commonManager_done.findCommonManager(ceo, emp4, emp3).id);

    }
}

