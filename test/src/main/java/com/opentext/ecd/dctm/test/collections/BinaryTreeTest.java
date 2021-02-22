package com.opentext.ecd.dctm.test.collections;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTest {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode.midOrderTree(root);
		System.out.println(TreeNode.midOrderTree2(root));
		TreeNode.posOrderTree(root);
		System.out.println(TreeNode.posOrderTree2(root));
		TreeNode.preOrderTree(root);
		System.out.println(TreeNode.preOrderTree2(root));
		System.out.println(TreeNode.levelOrder(root));
		
		String arrayString = "1234567890";
        // Creates an array of byte

        BufferedReader in = new BufferedReader(new StringReader(arrayString));
        String line;
        {
             root = stringToTreeNode(arrayString);
            prettyPrintTree(root);
        }

	}

//	public static String treeToString(TreeNode root) {
//		
//		TreeNode p = root;
//		StringBuilder sb = new StringBuilder();
//		sb.append(root.data);
//		sb.append(b)
//		if(root.left!=null) {
//			sb.append(root.left.data);
//		}
//		
//		while(p.left!=null) {
//			
//		}
//		return null;
//		
//	}
//	]

	static class TreeNode {

		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

		static void preOrderTree(TreeNode root) {
			if (root == null) {
				return;
			}

			System.out.println(root.data);
			preOrderTree(root.left);
			preOrderTree(root.right);

		}

		static List<Integer> preOrderTree2(TreeNode root) {
			if (root == null) {
				return new ArrayList<Integer>();
			}

			List<Integer> array = new ArrayList<Integer>();
			array.add(root.data);
			array.addAll(preOrderTree2(root.left));
			array.addAll(preOrderTree2(root.right));

			return array;

		}

		static void midOrderTree(TreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left != null) {
				midOrderTree(root.left);
			}
			System.out.println(root.data);
			if (root.right != null) {
				midOrderTree(root.right);
			}
		}

		static List<Integer> midOrderTree2(TreeNode root) {
			List<Integer> array = new ArrayList<Integer>();
			if (root == null) {
				return array;
			}

			array.addAll(midOrderTree2(root.left));
			array.add(root.data);
			array.addAll(midOrderTree2(root.right));
			return array;

		}

		static List<Integer> posOrderTree2(TreeNode root) {
			List<Integer> array = new ArrayList<Integer>();
			if (root == null) {
				return array;
			}

			array.addAll(posOrderTree2(root.left));
			array.addAll(posOrderTree2(root.right));
			array.add(root.data);
			return array;

		}

		static void posOrderTree(TreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left != null) {
				posOrderTree(root.left);
			}
			if (root.right != null) {
				posOrderTree(root.right);
			}
			System.out.println(root.data);

		}

//       static void levelTravel(TreeNode root) {
//    	   if(root==null) {
//    		   return;
//    	   }
//    	   
//    	   Queue<TreeNode> list = new LinkedList<TreeNode>();
//    	   list.offer(root);
//    	   
//    	   while(!list.isEmpty()) {
//    		  TreeNode node = list.poll();
//    		  System.out.println(node.data);
//    		  if(node.left!=null) {
//    		  list.offer(node.left);
//    		  }
//    		  
//    		  if(node.right!=null) {
//    			  list.offer(node.right);
//    		  }
//    	   } 
//    		  
//       }

		static List<List<Integer>> levelOrder2(TreeNode root) {

			if (root == null)
				return new ArrayList<>(0);

			List<List<Integer>> result = new ArrayList<>();
			Queue<Pair> list = new LinkedList<Pair>();
			list.offer(new Pair(root, 0));
			ArrayList<Integer> array = new ArrayList();
			array.add(root.data);
			

			while (!list.isEmpty()) {

				Pair p = list.poll();
				TreeNode node = p.node;
				if (!result.get(p.index).isEmpty()) {
					result.get(p.index).add(node.data);
				} else {
					 array = new ArrayList();
					array.add(node.data);
					result.add(p.index, array);
				}
				if (node.left != null) {
					list.offer(new Pair(node.left, p.index + 1));
				}

				if (node.right != null) {
					list.offer(new Pair(node.right, p.index + 1));
				}

			}

			return null;
		}

		 static List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null)
				return new ArrayList<>(0);

			List<List<Integer>> result = new ArrayList<>();

			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);

			Queue<TreeNode> curLevelNodes = new LinkedList<TreeNode>();

			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				curLevelNodes.offer(node);

				if (queue.isEmpty()) {
					List<Integer> list = new ArrayList<>(curLevelNodes.size());
					while (!curLevelNodes.isEmpty()) {
						TreeNode curNode = curLevelNodes.poll();
						list.add(curNode.data);

						if (curNode.left != null) {
							queue.offer(curNode.left);
						}

						if (curNode.right != null) {
							queue.offer(curNode.right);
						}

					}
					result.add(list);
				}
			}

			return result;
		}

	}
	
	

	static class Pair {
		TreeNode node;
		int index;

		Pair(TreeNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			TreeNode h = stack.pop();
			if (h != null) {
				sb.append(h.data + ",");
				stack.push(h.right);
				stack.push(h.left);
			} else {
				sb.append("#,");
			}
		}

		return sb.toString().substring(0, sb.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null)
			return null;

		int[] t = { 0 };
		String[] arr = data.split(",");

		return helper(arr, t);
	}

	public TreeNode helper(String[] arr, int[] t) {
		if (arr[t[0]].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

		t[0] = t[0] + 1;
		root.left = helper(arr, t);
		t[0] = t[0] + 1;
		root.right = helper(arr, t);

		return root;
	}
	
	 public static String treeNodeToString(TreeNode root) {
	        if (root == null) {
	            return "[]";
	        }

	        String output = "";
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.add(root);
	        while (!nodeQueue.isEmpty()) {
	            TreeNode node = nodeQueue.remove();

	            if (node == null) {
	                output += "null, ";
	                continue;
	            }

	            output += String.valueOf(node.data) + ", ";
	            nodeQueue.add(node.left);
	            nodeQueue.add(node.right);
	        }
	        return "[" + output.substring(0, output.length() - 2) + "]";
	    }

	    public static TreeNode stringToTreeNode(String input) {
	        input = input.trim();
	        input = input.substring(1, input.length() - 1);
	        if (input.length() == 0) {
	            return null;
	        }

	        String[] parts = input.split(",");
	        String item = parts[0];
	        TreeNode root = new TreeNode(Integer.parseInt(item));
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.add(root);

	        int index = 1;
	        while (!nodeQueue.isEmpty()) {
	            TreeNode node = nodeQueue.remove();

	            if (index == parts.length) {
	                break;
	            }

	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int leftNumber = Integer.parseInt(item);
	                node.left = new TreeNode(leftNumber);
	                nodeQueue.add(node.left);
	            }

	            if (index == parts.length) {
	                break;
	            }

	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int rightNumber = Integer.parseInt(item);
	                node.right = new TreeNode(rightNumber);
	                nodeQueue.add(node.right);
	            }
	        }
	        return root;
	    }

	    public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
	        if (node == null) {
	            System.out.println("Empty tree");
	            return;
	        }

	        if (node.right != null) {
	            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
	        }

	        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);

	        if (node.left != null) {
	            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
	        }
	    }

	    public static void prettyPrintTree(TreeNode node) {
	        prettyPrintTree(node, "", true);
	    }

}
