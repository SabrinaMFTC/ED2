/* Sabrina Midori F. T. de Carvalho      RA 10410220
   Estrutura de Dados II - Prof. Andre Kishimoto
   Turma 04G11 - Atividade 01C (Arvore Binaria)
   Referencias: materiais de aula
*/
package Default;

import Tree.*;

public class ProgramBT {

    public static void main(String[] args) {

        BinaryTree<String> bt = new BinaryTree<>();

        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");
        Node<String> nodeG = new Node<>("G");
        Node<String> nodeH = new Node<>("H");
        Node<String> nodeI = new Node<>("I");
        Node<String> nodeJ = new Node<>("J");
        Node<String> nodeK = new Node<>("K");

        bt.setRoot(nodeA);

        nodeA.setParent(null);
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setParent(nodeA);
        nodeB.setLeft(nodeD);
        nodeB.setRight(null);

        nodeC.setParent(nodeA);
        nodeC.setLeft(nodeE);
        nodeC.setRight(nodeF);

        nodeD.setParent(nodeB);
        nodeD.setLeft(null);
        nodeD.setRight(null);

        nodeE.setParent(nodeC);
        nodeE.setLeft(nodeG);
        nodeE.setRight(null);

        nodeF.setParent(nodeC);
        nodeF.setLeft(nodeH);
        nodeF.setRight(nodeI);

        nodeG.setParent(nodeE);
        nodeG.setLeft(nodeJ);
        nodeG.setRight(null);

        nodeH.setParent(nodeF);
        nodeH.setLeft(null);
        nodeH.setRight(nodeK);

        nodeI.setParent(nodeF);
        nodeI.setLeft(null);
        nodeI.setRight(null);

        nodeJ.setParent(nodeG);
        nodeJ.setLeft(null);
        nodeJ.setRight(null);

        nodeK.setParent(nodeH);
        nodeK.setLeft(null);
        nodeK.setRight(null);

        System.out.println(nodeA);
        System.out.println(nodeB);
        System.out.println(nodeC);
        System.out.println(nodeD);
        System.out.println(nodeE);
        System.out.println(nodeF);
        System.out.println(nodeG);
        System.out.println(nodeH);
        System.out.println(nodeI);
        System.out.println(nodeJ);
        System.out.println(nodeK);

        System.out.print("Is the tree empty? " + bt.isEmpty() + "\n");
        System.out.print("Tree's degree: " + bt.getDegree() + "\n");
        System.out.print("Tree's height: " + bt.getHeight() + "\n");

        System.out.println("In Order Traversal:");
        bt.inOrderTraversal();

        System.out.println("Pre Order Traversal:");
        bt.preOrderTraversal();

        System.out.println("Post Order Traversal:");
        bt.postOrderTraversal();
    }
}
