/*
 * Copyright (c) 2009, Swiss AviationSoftware Ltd. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the Swiss AviationSoftware Ltd. nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.sf.jcgm.imageio.plugins.cgm;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.ImageInputStream;

/*****************************************************************************
 * adapt an ImageInputStream to a "real" InputStream
 *
 * @author  xsln
 * @since 21.01.2015
 ****************************************************************************/
public class ImageInputToStreamAdapter extends InputStream {

	private ImageInputStream imageInput;

	/*************************************************************************
	 * Constructor
	 ************************************************************************/
	public ImageInputToStreamAdapter(ImageInputStream in) {
		super();
		this.imageInput = in;
	}
	
	
	/************************************************************************
	 * read
	 * @see java.io.InputStream#read()
	 ***********************************************************************/
	@Override
	public int read() throws IOException {
		return this.imageInput.read();
	}


	/************************************************************************
	 * read
	 * @see java.io.InputStream#read(byte[])
	 ************************************************************************/
	@Override
	public int read(byte[] b) throws IOException {
		return this.imageInput.read(b);
	}


	/************************************************************************
	 * read
	 * @see java.io.InputStream#read(byte[], int, int)
	 ***********************************************************************/
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return this.imageInput.read(b, off, len);
	}


	/************************************************************************
	 * available
	 * @see java.io.InputStream#available()
	 ************************************************************************/
	@Override
	public int available() throws IOException {
		long len = this.imageInput.length();
		return len < 0 ? 0 : (int) len; 
	}

	/************************************************************************
	 * markSupported
	 * @see java.io.InputStream#markSupported()
	 ************************************************************************/
	@Override
	public boolean markSupported() {
		return true;
	}

	/************************************************************************
	 * mark
	 * @see java.io.InputStream#mark(int)
	 ************************************************************************/
	@Override
	public void mark(int readlimit) {
		this.imageInput.mark();
	}

	/*************************************************************************
	 * reset
	 * @see java.io.InputStream#reset()
	 ***********************************************************************/
	@Override
	public void reset() throws IOException {
		this.imageInput.reset();
	}

	/*************************************************************************
	 * skip
	 * @see java.io.InputStream#skip(long)
	 ************************************************************************/
	@Override
	public long skip(long n) throws IOException {
		return this.imageInput.skipBytes(n);
	}


	/************************************************************************
	 * close
	 * @see java.io.InputStream#close()
	 ************************************************************************/
	@Override
	public void close() throws IOException {
		this.imageInput.close();
	}

}
