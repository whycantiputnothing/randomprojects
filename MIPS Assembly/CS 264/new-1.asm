		.data
array:	.space 80
prompt:	.asciiz "Enter a number: "
prompt2:.asciiz "Enter an integer n between 1 and 20: "
space: 	.asciiz " "
return: .asciiz "\n"
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

		li $t0,20
		la $t1, array
loop2:	lw $a0, ($t1)
		li $v0, 1
		syscall
		la $a0, return
		li $v0,4
		syscall
		addi $t1, $t1, 4
		addi $t0, $t0, -1
		bgtz $t0,loop2

		li $t0,20
		la $t1, array
loop3:	lw $a0, ($t1)
		li $v0, 1
		syscall
		la $a0, space
		li $v0,4
		syscall
		addi $t1, $t1, 4
		addi $t0, $t0, -1
		bgtz $t0,loop3

		la $a0, return
		li $v0,4
		syscall
		li $t0,20
		la $t1, array
		addi $t1, $t1, 76
loop4:	lw $a0, ($t1)
		li $v0, 1
		syscall
		la $a0, space
		li $v0,4
		syscall
		addi $t1, $t1, -4
		addi $t0, $t0, -1
		bgtz $t0,loop4
		
		
		la $a0, return
		li $v0,4
		syscall
askN:	la	$a0, prompt2 	#asks for n
		li	$v0, 4			#prints prompt2	
		syscall
		li	$v0, 5 			#reads int
		syscall 
		move $t2, $v0		#store n in t2
		add	$t3, $t2, -20	#t3 = t2-20
		bgtz $t3, askN		#t3 > 0 means n > 20, so loops back to input n

		li $t0,20
		li $t3,0
		la $t1, array
loop5:	lw $a0, ($t1)
		li $v0, 1
		syscall
		la $a0, space
		li $v0,4
		syscall
		addi $t1, $t1, 4
		addi $t0, $t0, -1
		addi $t3, $t3, 1
		beqz $t0, stop
		bltu $t3, $t2, loop5
		sub $t3, $t3, $t2 
		la $a0, return
		li $v0,4
		syscall
		bgtz $t0,loop5
	
stop:	li $v0, 10
		syscall
		