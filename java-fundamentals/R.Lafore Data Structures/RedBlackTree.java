package Lafor_Arrays;

public class RedBlackTree {
}
//Red-Black Rules
//When inserting (or deleting) a new node, certain rules are followed, the tree will be balanced.
//1. Every node is either red or black.
//2. The root is always black.
//3. If a node is red, its children must be black (although the converse isn’t necessarily true).
//4. Every path from the root to a leaf, or to a null child, must contain the same number of black nodes.

//Red-Black Tree Implementation
//add a red-black field (which can be type boolean) to the Node class.
//adapt the insertion routine from the BinaryTree.java program
// On the way down to the insertion point, check if the current node is black and its two children are both red.
// If so, change the color of all three (unless the parent is the root, which must be kept black).
//After a color flip, check that there are no violations of Rule 3.
//If so, perform the appropriate rotations: one for an outside grandchild, two for an inside grandchild.
//When you reach a leaf node, insert the new node as in tree.java,
// making sure the node is red. Check again for red-red conflicts, and perform any necessary rotations.

//You need to check only for violations of Rule 3, a red parent with a red child6
