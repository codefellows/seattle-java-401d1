# Linked Lists
`insertAfter`
`insertBefore`

which is easier?

why do we have to do "stopping one before"

building strings, toString



# TCP
the server waits for a connection
we can use a try-catch to recover from server not connecting to port

0101010101010101010110101010111110000
0101111011101000001111100011110000001

public void handleHTTPRequest(String request) {
  Scanner scanner = new Scanner(request);
  String line = scanner.nextLine();
  Scanner lineScanner = new Scanner(line);

  // pick off the initial method and route information
  String method = lineScanner.next();
  String route = lineScanner.next();

  // read in all headers
  while(scanner.hasNextLine() && !line.equals("")) {
    line = scanner.nextLine();
    lineScanner = new Scanner(line);

    String[] header = line.split(": ");
    String headerName = header[0];
    String headerValue = header[1];
  }

  String body = "";
  while (scanner.hasNextLine()) {
    body += scanner.nextLine() + "\n";
  }
}


# HTTP Request
POST /api/note HTTP/1.1
Host: api.example.com
Origin: www.example.com
Authorization: Beader bHVsIHRoaXMgaXMgYSBmYWtlIHNlY3JldCB0b2tlbg==
Accept: application/json
Content-Type: application/json; charset=UTF-8
Content-Length: 58

{"title":"kata","content":"get 100 points on hacker rank"}

# HTTP Response
HTTP/1.1 200 OK
Date: Tue, 22 Aug 2017 06:34:16 GMT
Content-Type: application/json; charset=UTF-8
Content-Encoding: UTF-8
Content-Length: 82
Last-Modified: Mon, 21 Aug 2017 12:10:38 GMT
Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
ETag: "3f80f-1b6-3e1cb03b"
Connection: close

{"id":"1234123412341324","title":"kata","content":"get 100 points on hacker rank"}








