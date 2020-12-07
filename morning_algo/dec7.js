// Stacks

// A stack is a LIFO data structure
// LAST IN, FIRST OUT
// LIFO

// push - add to top
// pop - remove from top
// peek - check the top
// isEmpty - check if the stack is empty, true/false
// length - return size of stack

class arrStack {
    constructor() {
        this.items = [];
    }

    push(item) {
        this.items.push(item);
    }

    pop() {
        return this.items.pop();
    }

    peek() {
        return this.items[this.items.length - 1];
    }

    isEmpty() {
        if (this.items.length === 0) {
            return true;
        }
        return false;
    }

    length(){
        return this.items.length;
    }
}

class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class slStack {
    constructor() {
        this.top = null; // this.head, this.end
        this.length = 0;
    }

    // add to top
    push(newNode) {
        newNode = this.top;
        this.top = this.next;
        length ++;
    }

    // remove from top
    pop() {
        if (this.top != null) {
            this.top = this.next;
            length --;
        } else {
            //nothing for us to pop.
            return null;
        }
    }

    //remove from top (Brendan's explanation)
    pop() {
        if (this.top === null) return null;

        const removed = this.top; //store previous top
        this.top = this.top.next; //move top pointer
        removed.next = null; //removes pointer from stored node
        this.length--; //decrement length

        return removed; //return the node
    }

    //Node myNode = mySLL.pop();

    // aka check top
    peek() {
        if (isEmpty()) {
            return null;
        } else {
            return this.top.data;
        }
    }

    //aka check top (Brendan)
    peek() {
        return this.head;
    }

    // check if empty
    isEmpty() {
        if (this.top == null) {
            return true;
            // return this.head === null;
            //or return null;
        }else{
            return false;
        }
    }

    // length getter
    length() {
        return this.length;
    }
}

// buh buh bonus challenge: countStack

// write the standalone function countStack
// given a slStack, count the nodes
// return the count
// you may use one stack or array as additional storage
// the given stack must be returned back to it's original order
// you may only use public stack methods push pop peek isempty
function countStack(stack) {};

