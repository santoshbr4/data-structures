// Queue.cpp 
// Author: Santosh B R (santoshbr4@gmail.com)

#include <iostream>

using namespace std;

typedef struct node_t 
{
	node_t *prev;
	node_t *next;
	int data;
}node;

node *front = 0, *rear = 0;

node *createNode(int data)
{
	node *p = (node *)malloc(sizeof(node));
	p->prev = p->next = 0;
	p->data = data;
	return p;
}

void enqueue(int data)
{
	node *p = createNode(data);
	p->next = front;

	if(front)
		front->prev = p;
	front = p;

	if (!rear)
		rear = front;
}

int dequeue()
{
	int ret = -1;
	if (!rear)
		return ret;

	node *t = rear->prev;
	ret = rear->data;

	free(rear);

	rear = t;
	if(rear)
		rear->next = 0;

	return ret;
}

int main()
{
	enqueue(100);
	enqueue(200);
	enqueue(300);

	cout << dequeue() << endl;
	cout << dequeue() << endl;
	cout << dequeue() << endl;
	cout << dequeue() << endl;

	enqueue(400);
	enqueue(500);

	cout << dequeue() << endl;
	cout << dequeue() << endl;
	cout << dequeue() << endl;

    return 0;
}
