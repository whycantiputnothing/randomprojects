			.data
array:		.space 480
recordT:	.space 48
newLine: 	.asciiz "\n"
newPara:	.asciiz "\n\n"
promptN:	.asciiz "Please enter a name (up to 40 characters): "
promptA:	.asciiz "Please enter an age: "
promptS:	.asciiz "Please enter a salary: "
prompt2:	.asciiz "Enter first record to be swapped(index begins at 0): "
prompt3:	.asciiz "Enter second record to be swapped(index ends at 9): "
name1:		.asciiz "name: "
age:		.asciiz "age: "
salary:		.asciiz "salary: "
entry:		.asciiz "Record #: "
			.globl main
			.text
main:	la $t0, array
		li $t1, 10
		li $t2, 0

loop1:	
		la $a0, promptN
		li $v0, 4
		syscall
		move $a0, $t0
		li $a1, 40
		li $v0, 8
		syscall
		
		la $a0, promptA
		li $v0, 4
		syscall
		li $v0, 5
		syscall
		sw $v0, 40($t0)
		
		la $a0, promptS
		li $v0, 4
		syscall
		li $v0, 5
		syscall
		sw $v0, 44($t0)
		la $a0, newLine
		li $v0, 4
		syscall
		
		addi $t0, $t0, 48
		addi $t1, $t1, -1
		bgtz $t1,loop1
		
		la $a0, newLine
		li $v0, 4
		syscall
		
		la $t0, array
		li $t1, 10
loop2:	la $a0, entry#
		li $v0, 4
		syscall
		move $a0, $t2
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		
		la $a0, name1
		li $v0, 4
		syscall
		move $a0, $t0
		li $v0, 4
		syscall
		
		la $a0, age
		li $v0, 4
		syscall
		lw $a0, 40($t0)
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall

		la $a0, salary
		li $v0, 4
		syscall
		lw $a0, 44($t0)
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		addi $t0, $t0, 48
		addi $t1, $t1, -1
		addi $t2, $t2, 1
		bgtz $t1,loop2
		
swap:	la $a0, prompt2 
		li $v0, 4
		syscall
		li $v0, 5
		syscall
		
		la $a1, array
		li $s0, 48
		mul $t1, $v0, $s0
		add $t0, $a1, $t1
		
		la $a0, recordT
		li $t2, 48
		
loop3:	lb $t1, ($t0)
		sb $t1, ($a0)
		addi $t0, $t0, 1
		addi $a0, $a0, 1
		addi $t2, $t2, -1
		bgtz $t2, loop3
		
		la $a0, prompt3 
		li $v0, 4
		syscall
		li $v0, 5
		syscall
		
		add $t1, $t0, -48
		mul $t2, $v0, $s0
		add $t0, $a1, $t2
		li $t3, 48
		
loop4:	lb $t2, ($t0)
		sb $t2, ($t1)
		addi $t0, $t0, 1
		addi $t1, $t1, 1
		addi $t3, $t3, -1
		bgtz $t3, loop4
		
		la $a0, recordT
		addi $t1, $t0, -48
		li $t3, 48
		
loop5:	lb $t2, ($a0)
		sb $t2, ($t1)
		addi $t1, $t1, 1
		addi $a0, $a0, 1
		addi $t3, $t3, -1
		bgtz $t3, loop5
		
		la $t0, array
		li $t1, 10
		li $t2, 0
loop6:	la $a0, entry#
		li $v0, 4
		syscall
		move $a0, $t2
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		
		la $a0, name1
		li $v0, 4
		syscall
		move $a0, $t0
		li $v0, 4
		syscall
		
		la $a0, age
		li $v0, 4
		syscall
		lw $a0, 40($t0)
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall

		la $a0, salary
		li $v0, 4
		syscall
		lw $a0, 44($t0)
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		addi $t0, $t0, 48
		addi $t1, $t1, -1
		addi $t2, $t2, 1
		bgtz $t1,loop6
		
end:	li $v0, 10
		syscall