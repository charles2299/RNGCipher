README

Overview

    RNGCipher is an encryption tool based off of the Vigenere Cipher(which
    is based off of the Caesar Cipher (AKA Caesar Shift)).

    The RNGCipher takes advantage of the fact that a RNG uses a "seed" such 
    that if two RNG has the same seed, they will produce the same "random"
    numbers. However, if two RNG has different seeds, even if the difference
    is small, they will produce two different streams of "random" numbers.

    The RNGCipher takes in a "password" that is mapped to a seed for an RNG.
    Then, each letter in the text file is shifted by a random number from
    our seeded RNG. The only way to unshift the letters is by knowing what
    the original seed or password are.

    Note: (Punctuations and any other characters that are not letters or 
    numbers are not shifted).

Usage

    Short Version(For Tech Savvy Cool Kids)

        To encrypt, copy/move the file you wish to encrypt into this
        directory (the one containing this README).

        Open up the command terminal, navigate to this directory, and type:

            java Encrypt plaintext.txt ciphertext.txt e

        Replace "plaintext.txt" with the name of the file you would like to 
        encrypt.
        Replace "ciphertext.txt" with the name of the file you would like 
        the encrypted text to be stored in. 
        The "e" stands for encrypt. 

        To decrypt, do the same thing except replace "e" with "d"

    Long Version

        In order to use the tool, first copy the text file that needs to be
        encrypted or decrypted into the folder containing this file (this
        should be the folder where all the RNGCipher files are located)

        To encrypt files, open up the command terminal, change to this
        directory and type:

            java Encrypt plaintext.txt ciphertext.txt e

        Replace "plaintext.txt" with the name of the file you would like to 
        encrypt.
        Replace "ciphertext.txt" with the name of the file you would like 
        the encrypted text to be stored in. 
        The "e" stands for encrypt. 

        Next, you will be prompted for a encryption key (or "password").
        Make sure that you remember the encryption key exactly! If you 
        forget it, you will not be able to decrypt the file. 
        Once you enter your password and press enter, the file will be 
        encrypted!

        Decrypting a file is very similar to encrypting a file. 
        Make sure the file you wish to decrypt is in the same folder as
        this README.
        Then, open up the command terminal, change to this directory and 
        type:

            java Encrypt ciphertext.txt plaintext.txt d

        Replace "ciphertext.txt" with the name of the encrypted file.
        Replace "plaintext.txt" with the name of the file that the 
        decrypted text should be written to.

        Next, you will be prompted for a encryption key (or "password").
        Make sure that you use the same encryption key as the one you used 
        to encrypt the file, else this will not work!
        Once you enter your password and press enter, the file will be 
        decrypted!

    Demo

        For demonstration, I have encrypted this README with the key
        "cipher" (no quotes). The encrypted version is in the file
        encryptedREADME.txt. Try encrypting the README with the same
        key and compare the two files. 

            java Encrypt README.txt trial1.txt e

        Then try, decrypting the file.

            java Encrypt trial1.txt output.txt d

A note on effectiveness

    After encrypting a file, on average, the number of A's, B's, C's ...
    are all about equal. This makes it difficult to crack this cipher by
    using purely frequency analysis. 

    This cipher also avoids the other weakness of Vigenere Cipher. A 
    Vigenere Cipher uses a repeated word to shift each letter. This
    cycle-ness makes Vigenere Ciphers vulnerable if one was able to 
    guess the length of the "key". Because there is no "cycle" in 
    this cycle, it avoids that weakness. 

    If you wish to see frequency analysis performed on an encrypted file,
    type:

        java FreqAnalysis encryptedfile.txt

    Replace "encryptedfile.txt" with the file name of an encrypted file 
    that you wish to perform FreqAnalysis on. Also, you can use

        java FreqAnalysis encryptedfile.txt d

    To see the standard deviations and how much each count deviates from
    average.

