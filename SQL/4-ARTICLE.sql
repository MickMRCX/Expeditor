USE [Expeditor]
GO

/****** Object:  Table [dbo].[Articles]    Script Date: 23/06/2016 11:12:13 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Articles](
	[Identifiant] [int] IDENTITY(1,1) NOT NULL,
	[Libelle] [ntext] NOT NULL,
	[Poids] [int] NOT NULL,
	[Archive] [bit] NOT NULL,
 CONSTRAINT [PK__Articles__DD380E4E5F6967F1] PRIMARY KEY CLUSTERED 
(
	[Identifiant] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

