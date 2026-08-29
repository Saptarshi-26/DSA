package Tree;

import java.util.*;

public class Main {
    static void input_tree(String arr[], int i, int n, ArrayList<Node> a) {
        if (i >= arr.length) return;
        ArrayList<Node> node = new ArrayList<>();
        for (int j = 0; j < a.size() && i < arr.length; j++) {
            if (!arr[i].equals("N")) {
                a.get(j).left = (new Node(Integer.parseInt(arr[i])));
                node.add(a.get(j).left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("N")) {
                a.get(j).right = (new Node(Integer.parseInt(arr[i])));
                node.add(a.get(j).right);
            }
            i++;
        }
        input_tree(arr, i, n * 2, node);
    }

    static Node input(String[] arr) {
        Node n = new Node(Integer.parseInt(arr[0]));
        ArrayList<Node> a = new ArrayList<>();
        a.add(n);
        input_tree(arr, 1, 2, a);
        return n;
    }

    static void level_wise_print(ArrayList<Node> arr) {
        ArrayList<Node> node = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null) {
                System.out.print(arr.get(i).data + " ");
                if (arr.get(i).left != null) {
                    node.add(arr.get(i).left);
                } else node.add(null);
                if (arr.get(i).right != null) {
                    node.add(arr.get(i).right);
                } else node.add(null);
            } else System.out.print("NULL  ");

        }
        if (node.isEmpty()) return;
        level_wise_print(node);


    }

    static void inorder_print(Node n) {
        if (n.left == null && n.right == null) {
            System.out.print(n.data + " ");
            return;
        }
        if (n.left != null) {
            inorder_print(n.left);
        }
        System.out.print(n.data + " ");
        if (n.right != null) {
            inorder_print(n.right);
        }

    }

    public static void main(String[] args) {
        Node n = new Node();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements of the tree level wise ");
        int nn = sc.nextInt();
        String[] arr = new String[nn];
        System.out.println("Enter the elements ");
        for (int i = 0; i < arr.length; i++) arr[i] = sc.next();
        n = input(arr);
        ArrayList<Node> node = new ArrayList<>();
        node.add(n);
        level_wise_print(node);
        // PreorderTraversalIterative p = new PreorderTraversalIterative();
        // PreorderTraversalIterativeII p  = new PreorderTraversalIterativeII();
        // PostorderTraversalIterative p = new PostorderTraversalIterative();
        // InoderTraversalIterative p = new InoderTraversalIterative();
        //p.inOrder(n);
        // VerticalTraversalBinaryTree.verticalOrder(n);
        //TopView.topView(n);
        //Bottomlfttreeval.findBottomLeftValue(n);
        //  BottomViewBinaryTree.bottomView(n);
        //Symetri_Tree.isSymmetric(n);
        //  PathSum.hasPathSum(n,2);
        //    BstToGreaterTree_leetocde.convertBST(n);
        // BstToGreaterTree_gfg.transformTree(n);
        // System.out.println(RootToLeafPaths.Paths(n));
        //  System.out.println(RootToLeafPaths_leetcode.binaryTreePaths(n));
        // System.out.println(PathFromRootwithSpecificSum.printPaths(n,-3));
        // System.out.println(SumTree.isSumTree(n));
        //  MirrorTree.mirror(n);
        //CoonectNodesOfLeaves.connect(n);
        // System.out.println(CheckForBst.isBST(n));
        //  System.out.println(ChechBst_II.isBST(n));
        // System.out.println(MaximumSum.findMaxSum(n));
        // System.out.println(Objects.requireNonNull(LowestCommonAncestor.lca(n, sc.nextInt(), sc.nextInt())).data);
        // System.out.println(TreeBoundaryTraversal.boundaryTraversal(n));
//        AVL_Tree_Insertion avlTreeInsertion = new AVL_Tree_Insertion();
//        level_wise_print(node);
//        do{
//           avlTreeInsertion.insertToAVL(n,sc.nextInt());
//           // level_wise_print(node);
//            System.out.println("enter true or false");
//        }while(sc.nextBoolean());
        // System.out.println(" \n " + Distribute_Candy_in_a_Binary_tree.distributeCandy(n));
        //      Normal_BST_To_Balanced_BST normalBstToBalancedBst = new Normal_BST_To_Balanced_BST();
        //    normalBstToBalancedBst.balanceBST(n);
//        Binary_Tree_to_DLL binaryTreeToDll = new Binary_Tree_to_DLL();
//        Node n1 = binaryTreeToDll.bToDLL(n);
//        while (n1 != null) {
//            System.out.print(n1.data + " ");
//            n1 = n1.next;

//        }

//        Flatten_Binary_Tree_into_LinkedList flattenBinaryTreeIntoLinkedList = new Flatten_Binary_Tree_into_LinkedList();
//        flattenBinaryTreeIntoLinkedList.flatten(n);
//        while (n != null) {
//            System.out.print(n.data + " ");
//            n = n.right;
//
//        }

//        Fixing_Two_Nodes_of_Bst fixingTwoNodesOfBst = new Fixing_Two_Nodes_of_Bst();
//        fixingTwoNodesOfBst.correctBST(n);
//        inorder_print(n);


//        System.out.println("enter the length of the array ");
//        int[] in = new int[sc.nextInt()];
//        int[] pr = new int[in.length];
//        System.out.println("enter the inorder of the tree ");
//        for (int i = 0; i < in.length; i++)
//            in[i] = sc.nextInt();
//        System.out.println("enter the preorder of the tree ");
//        for (int i = 0; i < pr.length; i++)
//            pr[i] = sc.nextInt();
//
//        ArrayList<Node > nodes  = new ArrayList<>(List.of(Construct_Tree_From_Inroder_and_Preorder.buildTree(in,pr)));
//        level_wise_print(nodes);

//        System.out.println("enter the length of the array ");
//        int[] in = new int[sc.nextInt()];
//        int[] pr = new int[in.length];
//        System.out.println("enter the preorder of the tree ");
//        for (int i = 0; i < in.length; i++)
//            in[i] = sc.nextInt();
//        System.out.println("enter the postorder of the tree ");
//        for (int i = 0; i < pr.length; i++)
//            pr[i] = sc.nextInt();
//
//        ArrayList<Node > nodes  = new ArrayList<>(List.of(Construct_Tree_from_Pre_and_Post_Order.constructTree(in,pr)));
//        level_wise_print(nodes);
//        Cousin_In_Binary_Tree cousinInBinaryTree = new Cousin_In_Binary_Tree();
//        System.out.println(cousinInBinaryTree.isCousins(n,11,17));

//        Serialize_and_Deserialize_a_Binary_Tree deserializeABinaryTree = new Serialize_and_Deserialize_a_Binary_Tree();
//        String s = deserializeABinaryTree.serialize(n);
//        deserializeABinaryTree.deserialize(s);

//
//        Burning_Tree_1 burningTree = new Burning_Tree_1();
//        System.out.println(burningTree.minTime(n,sc.nextInt()));

//        Maximum_Width_of_Binary_Tree maximumWidthOfBinaryTree = new Maximum_Width_of_Binary_Tree();
//        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(n));

        House_Robber_III houseRobberIii = new House_Robber_III();
        System.out.println(houseRobberIii.rob(n));
    }


}
