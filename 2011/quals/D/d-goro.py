#! /usr/bin/python

f_in="D-large.in"
f_out="d-out.txt"

def do_puzzle(fp_in):
    N = int(fp_in.readline())
    array = map(int, fp_in.readline().split())
    num_to_fix = 0
    for i in range(N):
        if array[i] != i+1:
            num_to_fix += 1
    return num_to_fix

if __name__ == "__main__":
    fp_in = open(f_in)
    fp_out = open(f_out, 'w')
    T = int(fp_in.readline())
    for i in range(T):
        ans = do_puzzle(fp_in)
        fp_out.write("Case #%s: %s\n" % (i+1, ans))
    fp_in.close()
    fp_out.close()
    
