Gatekeeping Gaslighting Girlbosses: Lauren Lee, Kevin Xiao, Kevin Li
APCS pd8
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05
time spent: 0.5 hrs


DISCO
------------------------------------------------
* The post-order arrangement of the tree is KNOWLIDGE
* First node of pre-order is the last node of post-order because the root is processed first in pre-order and last in post-order
* the reconstructed tree looks like:
      E
       \
        G
       / 
      D 
     / \
    K   I
       / \
      N   L
         / \
        O   W
        
pre-order: EGDKINLOW
in-order:  EKDNIOLWG

there are many reversed sections in the pre-order and in-order traversals
pre-order: EG [DK] [IN] [LO] W
in-order:  E [KD] [NI] [OL] WG
these reversed sections indicate straight branching to a leaf on the left
 - K is a leaf on the left branch of D
 - N is a leaf on the left branch of I
 - O is a leaf on the left branch of L
 
Additionally, G and W are in reversed sequence
pre-order: E [G] DKINLO [W]
in-order:  EKDNIOL [WG]
but in pre-order, G and W are separated by [DKINLO], because D branches off of G to the left 

This could be an algorithm to reconstruct trees given pre-order and in-order
================================================


QCC
------------------------------------------------
* Is there a way to convert one ordered traversal to another?
* We are reminded of hamiltonian paths and circuits, but neither seems to be a good descriptor of a tree
* Does a traversal count as a hamiltonian circuit? If we use the analogy of unfurling something and letting it come back, then the start and end would be the same
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
	- Down

Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
	- Abstract Data Type
    - Acyclic graph
    - 

Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
	- To distinguish the tree from being a complete or balanced tree
  	- Although it can be distinct even without the height difference
    - Maybe to distinguish between complete trees and trees with incomplete bottoms

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
	- Acyclic graph

Is a perfect tree complete? 
	- Yes because a perfect tree has all it's levels filled in

Is a complete tree balanced? 
	- Yes because the left and right subtrees of a complete tree are of height differing at most one, since only the bottom layer can be not fully filled

Is the Man Who Is Tall Happy?
	- Of course. Height = power in our modern society and height is seen as a dominating feature for men. More height = good!

What must be true of perfect trees but not others?
	- It is complete AND balanced
================================================


C'EST POSSIBLE?
------------------------------------------------
It's possible because we did it
================================================



