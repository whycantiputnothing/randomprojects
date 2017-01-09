		.data
array:	.space 80
prompt:	.asciiz "Enter a number: "
return: .asciiz "\n"
sMsg:	.asciiz "Smallest number: "
bMsg:	.asciiz "Biggest number: "
fours:	.asciiz "Number of integers disvisble by 4: "
		.globl main
		.text
		
main:	li $t0, 20 
		la $t1, array
		la $a0, prompt
		
loop1:	li $v0,4
		syscall
		li $v0,5
		syscall
		sw $v0, ($t1)
		addi $t1, $t1, 4
		addi $t0, $t0, -1
		bgtz $t0,loop1
		
		li $v0, 4
		la $a0, sMsg
		syscall
		
		la $a0, array
		li $a1, 20
		jal smallestLargest
		
		move $a0, $v0
		li $v0, 1
		syscall
		li $v0,4
		la $a0,return
		syscall
		li $v0,4
		la $a0,bMsg
		syscall
		move $a0, $v1
		li $v0, 1
		syscall
		li $v0,4
		la $a0,return
		syscall
		
		
		li $v0, 4
		la $a0, fours
		syscall
		la $a0, array
		li $a1, 20
		jal divisble
		move $a0, $v0
		li $v0, 1
		syscall

stop:	li $v0, 10
		syscall
		
smallestLargest:
		li $v0, 2147483647
		li $v1, -2147483648

little1:blez $a1, big
		addi $a1, $a1, -1
		lw $t0, 0($a0)
		addi $a0, $a0, 4
		blt $t0, $v0, little2
		b little1

little2:move $v0, $t0
		b little1
		
big:	addi $a1, $a1, 20
		addi $a0, $a0, -80
big1:	blez $a1, retzz
		addi $a1, $a1, -1
		lw $t0, 0($a0)
		addi $a0, $a0, 4
		bgt $t0, $v1, big2
		b big1
		
big2: 	move $v1, $t0
		b big1
		
retzz: jr $ra

divisble:	
		li $v0,0
		li $t0, 4
		
loop3:	blez $a1, retzzz
		addi $a1, $a1, -1
		lw $t1, 0($a0)
		addi $a0, $a0, 4
		rem $t2, $t1, $t0
		beqz $t2, four
		b loop3
		
four:	addi $v0, $v0, 1
		b loop3

retzzz: jr $ra