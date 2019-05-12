// Stack.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

typedef struct node_t {
	node_t *next;
	int data;
}node;

node* createNode(int data) {
	node *p = (node*)malloc(sizeof(node));
	p->data = data;
	p->next = 0;
	return p;
}

void push(node **top, int data)
{
	node *p = createNode(data);

	p->next = *top;
	*top = p;
}

int pop(node **top) {
	node *t = (*top)->next;
	int ret = (*top)->data;
	free(*top);
	*top = t;
	return ret;
}

int main()
{
	node *top = 0;

	push(&top, 2);
	push(&top, 3);
	cout << pop(&top) << endl;
	push(&top, 4);
	cout << pop(&top) << endl;
	cout << pop(&top) << endl;

	return 0;
}

