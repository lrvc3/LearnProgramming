

// Smaller input of root is left and right :P
int height(Node* root){

	// Base Condition
	if(root == NULL){
		return 0;
	}

	// Hypothesis
	int left = height(root->left);
	int right = height(root->right);

	// Induction
	return 1 + max(left, right);

}