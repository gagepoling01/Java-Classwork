This program compares your password to a wordlist of over 70,000 "common" passwords and sees if:
1. The password is in the "common" password list.
2. If the password is an inverse of a word in the list (drowssap)
3. If the password is a reflection of a word in the list (passworddrowssap)

Ideally there's a 4th check that I never implemented where it checks for numbers at the end (password123) and
would still tell you to change the password.

If any of these checks occur, it tells you what is wrong with your password and to pick something stronger. 
If none of these checks occur, it tells you the password is good.

Unfortunately I've gone and lost the wordlist, but the program just reads from a basic text file.

If I remember correctly, there was a bug where if you type in a non-unique password, it'll say the password isn't unique,
but it will also say it's mirroring itself when it's not.
