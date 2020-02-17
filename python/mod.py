import os
import sys

inFile = open(sys.argv[1],'r') # read file
outFile = open(sys.argv[2],'w') # wrtie file

lines = inFile.readlines() # read multi lines
# line = inFile.readline() # read one line / first line

print("Testing and debuging:\n")
for line in lines:
	# Extract number for mod
	# EX: 69 | kings
	number, text = line.strip().split("|")
	mod_number = int(number) % 2
	print('{}|{}\n'.format(mod_number,text))
	outFile.write('{}|{}\n'.format(mod_number,text)) 

inFile.close() # close file in/out
outFile.close() # clouse file in/out
