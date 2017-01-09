			.data
array:	.space 400
space:		.asciiz " "
newLine: 	.asciiz "\n"
count:		.asciiz "The number of integers in the array: "
sum:		.asciiz "The sum is: "
prompt:		.asciiz "Enter an integer: "
			.globl main
			.text
main:	la $a0, array
		jal Test1
		move $t0, $v0
		la $a0, count
		li $v0, 4
		syscall
		move $a0, $t0
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		la $a0, sum
		li $v0, 4
		syscall
		move $a0, $v1
		li $v0, 1
		syscall
		li $v0, 10
		syscall

Test1:	li $t0, -100
		move $t1, $a0
		move $t2, $a0
		la $a0, prompt
		
loop1:	li $v0,4
		syscall
		li $v0,5
		syscall
		sw $v0, ($t1)
		addi $t1, $t1, 4
		addi $t0, $t0, 1
		bltz $v0, out1
		bltz $t0, loop1		
		
out1:	add $v0, $t0, 99
		move $t0, $v0
		
loop2:	lw $t3, ($t2)
		bltz $t3, retzz
		add $v1, $v1, $t3
		addi $t2, $t2, 4
		addi $t0, $t0, -1
		bgtz $t0, loop2
		
		
retzz: jr $ra