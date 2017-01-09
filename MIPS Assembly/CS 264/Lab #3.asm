		.data
buffer:	.space 20
array:	.space 512
prompt:	.asciiz "Enter a string(max 20 characters): "
return: .asciiz "\n"
space:	.asciiz " "
number: .asciiz "Number of "
spaceC: .asciiz "Number of spaces "
isPali:	.asciiz "Is it a palindrone? (0 is no, 1 is yes) "
		.globl main
		.text
		
main:	la $a0, prompt
		li $v0, 4
		syscall
		
		la $a0, buffer
		la $a1, 20
		li $v0, 8
		syscall
		
		li $t4, 4
		la $a0, buffer
		
		
loop1: 	la $t0, array
		lb $t1, ($a0)
		beqz $t1, next
		addi $a0, $a0, 1
		mul $t1, $t1, 4
		add $t0, $t0, $t1
		lw $t2, ($t0)
		addi $t2, $t2, 1
		sw $t2, ($t0)
		b loop1
		

next: 	la $a0, spaceC
		li $v0, 4
		syscall
		la $a0, array
		addi $a0, $a0, 128
		lw $t0, ($a0)
		move $a0, $t0
		li $v0, 1
		syscall
		la $a0, return
		li $v0, 4
		syscall

		la $a1, array	
		addi $a1, $a1, 260
		li $t0, 65
		li $t1, 26
printUpper:
		la $a0, number
		li $v0, 4
		syscall
		move $a0, $t0
		li $v0, 11
		syscall
		la $a0, space
		li $v0, 4
		syscall
		lw $a0, ($a1)
		li $v0, 1
		syscall
		la $a0, return
		li $v0, 4
		syscall
		addi $a1, $a1, 4
		addi $t1, $t1, -1
		addi $t0, $t0, 1
		blez $t1, next2
		b printUpper
		
next2:	la $a1, array	
		addi $a1, $a1, 388
		li $t0, 97
		li $t1, 26
		
printLower:	
		la $a0, number
		li $v0, 4
		syscall
		move $a0, $t0
		li $v0, 11
		syscall
		la $a0, space
		li $v0, 4
		syscall
		lw $a0, ($a1)
		li $v0, 1
		syscall
		la $a0, return
		li $v0, 4
		syscall
		addi $a1, $a1, 4
		addi $t1, $t1, -1
		addi $t0, $t0, 1
		blez $t1, next3
		b printLower
		
next3:
		la $a0, isPali
		li $v0, 4
		syscall
		la $a0, buffer
		jal pali
		move $a0, $v0
		li $v0, 1
		syscall
		la $a0, return
		li $v0, 4
		syscall

stop:	li $v0, 10
		syscall

pali:	li $v0, 1

		slti $t0, $a1, 2
		bnez $t0, retzz
		
		move $t1, $a0
		move $t2, $a0
		
len:	lb $t3, ($t2)
		beqz $t3, endLen
		addi $t2, $t2, 1
		b len
		
endLen:	addi $t2, $t2, -2

loop2:	bge $t1, $t2, retzz
		lb $t3, ($t1)
		lb $t4, ($t2)
		bne $t3, $t4, false
		addi $t1, $t1, 1
		addi $t2, $t2, -1
		b loop2

		
false:	li $v0, 0
		b retzz
		
retzz: jr $ra


		