# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        n = len(preorder)

        pre_idx = in_index = 0
        def dfs(limit):

            nonlocal pre_idx, in_index

            if pre_idx >= n:
                return None

            if inorder[in_index] == limit:
                in_index += 1
                return None

            root_value = preorder[pre_idx]
            pre_idx += 1
            root = TreeNode(root_value)
            root.left = dfs(root_value)
            root.right = dfs(limit)
            return root
            
        return dfs(float('inf'))



            
        