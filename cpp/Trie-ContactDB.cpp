// TrieDataStructure.cpp : Defines the entry point for the console application.
// hacker rank - https://www.hackerrank.com/challenges/contacts/problem

//#include "stdafx.h"
#include <iostream>
#include <string.h>

using namespace std;

typedef struct trie_t {
	trie_t *head[26];
	bool isWordEnd;
	char ch;
	int counts;
}trie;

trie *t[26];
int counter = 0;

trie *createNode(char ch)
{
	trie *p = (trie*)malloc(sizeof(trie));
	for (int i = 0; i < 26; i++)
		p->head[i] = 0;

	p->ch = ch;
	p->isWordEnd = false;
	p->counts = 1;
	return p;
}

void insertIntoTrie(trie **cur, char ch) {
	if (ch == '\0')
	{
		(*cur)->isWordEnd = true;
		return;
	}
	if (*cur == 0)
	{
		if(!t[ch - 'a'])
		{
			trie *p = createNode(ch);
			t[ch - 'a'] = p;
		}
		else
			t[ch - 'a']->counts++;

		*cur = t[ch - 'a'];
	}
	else
	{
		if ((*cur)->head[ch - 'a'])
		{
			*cur = (*cur)->head[ch - 'a'];
			(*cur)->counts++;
		}
		else
		{
			trie *p = createNode(ch);
			(*cur)->head[ch - 'a'] = p;
			*cur = (*cur)->head[ch - 'a'];
		}
	}
}

void insert(char array[]) {
	int i = 0;
	char ch = array[i];
	trie *cur = 0;
	while (ch != '\0') {
		i++;
		insertIntoTrie(&cur, ch);
		ch = array[i];
	}
	insertIntoTrie(&cur, '\0');
}

int findPartialCount(char array[])
{
	int i = 0;
	char ch = array[i];
	trie *cur = 0;
	while (ch != '\0') {
		i++;
		if (cur == 0)
		{
			cur = t[ch - 'a'];
			if (cur == 0)
				return 0;
		}
		else
		{
			cur = cur->head[ch - 'a'];
			if (cur == 0)
				return 0;
		}
		ch = array[i];
	}
	
	return cur->counts;
}


int main()
{
	char op[32];
	char name[22];
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> op;
		if (strcmp(op, "add") == 0)
		{
			cin >> name;
			insert(name);
		}
		else
		{
			cin >> name;
			counter  = findPartialCount(name);
			cout << counter << endl;
			counter = 0;
		}
	}
	return 0;
}
