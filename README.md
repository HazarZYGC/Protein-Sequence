# Protein-Sequence

I developed an algorithm for solving protein sequence alignment
which aims to find optimum matching between two amino acid sequences. <br />

Inputs are: two given strings ```x```, ```y``` where ```length(x)=m``` and ```length(y)=n```, and a cost matrix C which prescribes a
cost for matching and mismatching characters. A gap penalty is the component deducted from
alignment score due to the presence of a gap, i.e., matching of a letter in one sequence with a
dash (space) in the other sequence. A gap penalty may be a function of the length of the gap;
for example, a linear gap penalty is a constant ```g ``` such that each inserted or deleted symbol is
charged ```g```; the total cost of a gap of length ```L``` is equal to ```gL```.

## Input:
1.Two protein strings x and y, each one is in one line of the file (at most 1000 amino acid) <br />
2.Cost matrix (BLOSUM62 scoring matrix) <br />
3.Linear gap penalty equal to -5 (i.e., a cost of -5 is assessed for each gap symbol) <br />

## Output:
1.The maximum alignment score between x and y.  <br />
2.Best alignment between x and y.
